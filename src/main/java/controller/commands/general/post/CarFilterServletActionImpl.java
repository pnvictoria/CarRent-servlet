package controller.commands.general.post;

import controller.interfaces.ServletAction;
import dao.dto.CarFilterDAO;
import dto.CarFilterDTO;
import entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.dto.CarFilterService;
import service.interfaces.FilterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarFilterServletActionImpl implements ServletAction {
    private static final Logger LOG = LoggerFactory.getLogger(CarFilterServletActionImpl.class);
    private final FilterService<Car, CarFilterDTO> filterService;

    public CarFilterServletActionImpl(FilterService<Car, CarFilterDTO> filterService) {
        this.filterService = filterService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("filterList");
        String name = valueOrNull(req.getParameter("name"));
        String labelId = valueOrNull(req.getParameter("label_id"));
        String levelId = valueOrNull(req.getParameter("level_id"));
        String priceFrom = valueOrNull(req.getParameter("price_from"));
        String priceTo = valueOrNull(req.getParameter("price_to"));
        try {
            CarFilterDTO carFilterObject = CarFilterDTO.newBuilder()
                    .setLabelId(labelId != null ? Integer.parseInt(labelId) : null)
                    .setLevelId(levelId != null ? Integer.parseInt(levelId) : null)
                    .setName(name)
                    .setPriceFrom(priceFrom != null ? Integer.parseInt(priceFrom) : 0)
                    .setPriceTo(priceTo != null ? Integer.parseInt(priceTo) : Integer.MAX_VALUE).build();

            List<Car> foundList = filterService.getFilteredObjects(carFilterObject);
            req.getSession().setAttribute("filterList", foundList);
        } catch (Exception e) {
            LOG.error("Exception: {}", e.getMessage(), e);
            req.setAttribute("error", e.getMessage());
        }
        //TODO: replace to correct page
        return "/main";
    }

    /* Если строка пустая нам нужо заменить ее на Null чтоб наш запрос отработал правильно*/
    private String valueOrNull(String value) {
        if(value == null) {
            return null;
        }
        if(value.isEmpty()) {
            return null;
        } else {
            return value;
        }
    }
}
