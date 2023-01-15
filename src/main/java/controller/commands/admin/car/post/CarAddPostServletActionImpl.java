package controller.commands.admin.car.post;

import controller.commands.admin.car.get.CarAddGetServletActionImpl;
import controller.interfaces.ServletAction;
import dao.CarDAO;
import dao.LabelDAO;
import dao.LevelDAO;
import entity.Car;
import entity.Label;
import entity.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CarService;
import service.LabelService;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CarAddPostServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(CarAddPostServletActionImpl.class);

    private final MainService<Car> carService;
    private final MainService<Label> labelService;
    private final MainService<Level> levelService;
    private final String ADMIN_CAR_HOME_PAGE;
    private final String ADMIN_CAR_ADD_PAGE;

    public CarAddPostServletActionImpl(MainService<Car> carService,
                                       MainService<Label> labelService,
                                       MainService<Level> levelService) {
        this.carService = carService;
        this.labelService = labelService;
        this.levelService = levelService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = property.getCommandsProperty("ADMIN_CAR_HOME");
        ADMIN_CAR_ADD_PAGE = property.getCommandsProperty("ADMIN_CAR_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Car car = Car.newBuilder()
                    .setName(req.getParameter("name"))
                    .setPrice(Integer.parseInt(req.getParameter("price")))
                    .setJpg(req.getParameter("jpg"))
                    .setLevel(getLevelFromList(req.getParameter("level_name")))
                    .setLabel(getLabelFromList(req.getParameter("label_name")))
                    .setDesc(req.getParameter("desc"))
                    .build();
            if(carService.addObject(car)) {
                return ADMIN_CAR_HOME_PAGE;
            }
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return ADMIN_CAR_ADD_PAGE;
    }

    private Label getLabelFromList(String labelId){
        try {
            return labelService.getObjectById(Integer.parseInt(labelId));
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return Label.newBuilder().build();
    }

    public Level getLevelFromList(String levelId){
        try {
            return levelService.getObjectById(Integer.parseInt(levelId));

        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return Level.newBuilder().build();
    }
}
