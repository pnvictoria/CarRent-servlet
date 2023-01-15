package controller.commands;

import controller.commands.admin.car.get.CarAddGetServletActionImpl;
import controller.commands.admin.car.get.CarHomeServletActionImpl;
import controller.commands.admin.car.get.CarUpdateGetServletActionImpl;
import controller.commands.admin.car.post.CarAddPostServletActionImpl;
import controller.commands.admin.car.post.CarDeleteServletActionImpl;
import controller.commands.admin.car.post.CarUpdatePostServletActionImpl;
import controller.commands.admin.label.get.LabelAddGetServletActionImpl;
import controller.commands.admin.label.get.LabelHomeServletActionImpl;
import controller.commands.admin.label.get.LabelUpdateGetServletActionImpl;
import controller.commands.admin.label.post.LabelAddPostServletActionImpl;
import controller.commands.admin.label.post.LabelDeletePostServletActionImpl;
import controller.commands.admin.label.post.LabelUpdatePostServletActionImpl;
import controller.commands.admin.level.get.LevelAddGetServletActionImpl;
import controller.commands.admin.level.get.LevelHomeServletActionImpl;
import controller.commands.admin.level.get.LevelUpdateGetServletActionImpl;
import controller.commands.admin.level.post.LevelAddPostServletActionImpl;
import controller.commands.admin.level.post.LevelDeleteServletActionImpl;
import controller.commands.admin.level.post.LevelUpdatePostServletActionImpl;
import controller.commands.admin.order.get.OrderHomeServletActionImpl;
import controller.commands.admin.order.post.OrderApproveServletActionImpl;
import controller.commands.admin.order.post.OrderBlockServletActionImpl;
import controller.commands.admin.role.get.RoleAddGetServletActionImpl;
import controller.commands.admin.role.get.RoleHomeServletActionImpl;
import controller.commands.admin.role.get.RoleUpdateGetServletActionImpl;
import controller.commands.admin.role.post.RoleAddPostServletActionImpl;
import controller.commands.admin.role.post.RoleDeleteServletActionImpl;
import controller.commands.admin.role.post.RoleUpdatePostServletActionImpl;
import controller.commands.admin.user.get.UserHomeServletActionImpl;
import controller.commands.admin.user.post.UserDeleteServletActionImpl;
import controller.commands.general.get.ErrorPageGetServletAction;
import controller.commands.general.get.MainPageGetServletActionImpl;
import controller.commands.general.post.CarFilterServletActionImpl;
import controller.commands.general.post.ImageUploadServletActionImpl;
import controller.commands.user.page.UserCarRentGetServletAction;
import controller.commands.user.rent.CarRentGetServletActionImpl;
import controller.commands.user.page.UserPageGetServletAction;
import controller.commands.user.rent.CarRentPostServletActionImpl;
import controller.commands.user.sign_in.SignInGetServletAction;
import controller.commands.user.sign_in.SignInPostServletAction;
import controller.commands.user.sign_out.UserSignOutServletAction;
import controller.commands.user.sign_up.SignUpGetServletAction;
import controller.commands.user.sign_up.SignUpPostServletAction;
import controller.interfaces.ServletAction;
import dao.*;
import dao.dto.CarFilterDAO;
import database.DataBaseConnection;
import dto.CarFilterDTO;
import entity.*;
import service.*;
import service.dto.CarFilterService;
import service.interfaces.FilterService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.HashMap;

public class CommandManager {
    private Connection connection;
    private MainService<Label> labelService;
    private MainService<Level> levelService;
    private MainService<Role> roleService;
    private MainService<Car> carService;
    private MainService<User> userService;
    private MainService<Order> orderService;
    private MainService<State> stateService;

    private FilterService<Car, CarFilterDTO> filterService;

    public static final HashMap<String, ServletAction> commands = new HashMap<>();

    public CommandManager() {
        connection = DataBaseConnection.initialize();
        this.labelService = new LabelService(new LabelDAO(connection));
        this.levelService = new LevelService(new LevelDAO(connection));
        this.roleService = new RoleService(new RoleDAO(connection));
        this.carService = new CarService(new CarDAO(connection));
        this.userService = new UserService(new UserDAO(connection));
        this.orderService = new OrderService(new OrderDAO(connection));
        this.stateService = new StateService(new StateDAO(connection));

        this.filterService = new CarFilterService(new CarFilterDAO(connection));

        ReadPropertiesFile pr = new ReadPropertiesFile();
        // general
        commands.put(pr.getCommandsProperty("MAIN"), new MainPageGetServletActionImpl(labelService,levelService));
        commands.put(pr.getCommandsProperty("ERROR"), new ErrorPageGetServletAction());

        commands.put(pr.getCommandsProperty("SIGN_IN"), new SignInGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_IN_POST"), new SignInPostServletAction(userService));
        commands.put(pr.getCommandsProperty("SIGN_UP"), new SignUpGetServletAction());
        commands.put(pr.getCommandsProperty("SIGN_UP_POST"), new SignUpPostServletAction(userService));
        commands.put(pr.getCommandsProperty("SIGN_OUT"), new UserSignOutServletAction());
        commands.put(pr.getCommandsProperty("UPLOAD_IMAGE_POST"), new ImageUploadServletActionImpl(userService));
        commands.put(pr.getCommandsProperty("FILTER_CARS"), new CarFilterServletActionImpl(filterService));

        // user
        commands.put(pr.getCommandsProperty("USER_MAIN"), new UserPageGetServletAction());
        commands.put(pr.getCommandsProperty("USER_CAR_RENT"), new UserCarRentGetServletAction(orderService));
        commands.put(pr.getCommandsProperty("CAR_RENT"), new CarRentGetServletActionImpl(carService));
        commands.put(pr.getCommandsProperty("CAR_RENT_POST"), new CarRentPostServletActionImpl(orderService, carService));

        // admin-user
        commands.put(pr.getCommandsProperty("ADMIN_USER_HOME"), new UserHomeServletActionImpl(userService));
        commands.put(pr.getCommandsProperty("ADMIN_USER_DELETE"), new UserDeleteServletActionImpl(userService));
        // admin-car
        commands.put(pr.getCommandsProperty("ADMIN_CAR_HOME"), new CarHomeServletActionImpl(carService));
        commands.put(pr.getCommandsProperty("ADMIN_CAR_ADD"), new CarAddGetServletActionImpl(labelService,levelService));
        commands.put(pr.getCommandsProperty("ADMIN_CAR_ADD_POST"), new CarAddPostServletActionImpl(carService,labelService,levelService));
        commands.put(pr.getCommandsProperty("ADMIN_CAR_UPDATE"), new CarUpdateGetServletActionImpl(carService,labelService,levelService));
        commands.put(pr.getCommandsProperty("ADMIN_CAR_UPDATE_POST"), new CarUpdatePostServletActionImpl(carService));
        commands.put(pr.getCommandsProperty("ADMIN_CAR_DELETE"), new CarDeleteServletActionImpl(carService));
        // admin-role
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_HOME"), new RoleHomeServletActionImpl(roleService));
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_ADD"), new RoleAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_ADD_POST"), new RoleAddPostServletActionImpl(roleService));
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_UPDATE"), new RoleUpdateGetServletActionImpl(roleService));
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_UPDATE_POST"), new RoleUpdatePostServletActionImpl(roleService));
        commands.put(pr.getCommandsProperty("ADMIN_ROLE_DELETE"), new RoleDeleteServletActionImpl(roleService));
        // admin-label
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_HOME"), new LabelHomeServletActionImpl(labelService));
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_ADD"), new LabelAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_ADD_POST"), new LabelAddPostServletActionImpl(labelService));
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_UPDATE"), new LabelUpdateGetServletActionImpl(labelService));
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_UPDATE_POST"), new LabelUpdatePostServletActionImpl(labelService));
        commands.put(pr.getCommandsProperty("ADMIN_LABEL_DELETE"), new LabelDeletePostServletActionImpl(labelService));
        // admin-level
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_HOME"), new LevelHomeServletActionImpl(levelService));
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_ADD"), new LevelAddGetServletActionImpl());
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_ADD_POST"), new LevelAddPostServletActionImpl(levelService));
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_UPDATE"), new LevelUpdateGetServletActionImpl(levelService));
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_UPDATE_POST"), new LevelUpdatePostServletActionImpl(levelService));
        commands.put(pr.getCommandsProperty("ADMIN_LEVEL_DELETE"), new LevelDeleteServletActionImpl(levelService));
        //admin-order
        commands.put(pr.getCommandsProperty("ADMIN_ORDER_HOME"), new OrderHomeServletActionImpl(orderService));
        commands.put(pr.getCommandsProperty("ADMIN_ORDER_APPROVE"), new OrderApproveServletActionImpl(orderService,stateService));
        commands.put(pr.getCommandsProperty("ADMIN_ORDER_BLOCK"), new OrderBlockServletActionImpl(orderService,stateService));
    }

    public ServletAction getCommand(HttpServletRequest request) {
        String command = getMapping(request);
        if (commands.get(command) == null) {
            return commands.get("/main");
        }
        return commands.get(command);
    }

    private String getMapping(HttpServletRequest request) {
        String mapping = request.getRequestURI().substring(request.getContextPath().length());
        if (mapping.isEmpty()) {
            return "/";
        }
        if (mapping.endsWith("/")) {
            mapping = mapping.substring(0, mapping.length() - 1);
        }
        return mapping;
    }
}
