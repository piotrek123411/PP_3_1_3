package web.preload;

import org.springframework.security.crypto.password.PasswordEncoder;
import web.dao.RoleDAOImpl;
import web.dao.UserDAOImpl;
import web.model.Role;
import web.model.User;

import java.util.HashSet;

public class PreloadDatabase {

    private static PasswordEncoder passwordEncoder;
    private static RoleDAOImpl roleDAO;
    private static UserDAOImpl userDAO;
    public static void preload() {
        Role roleAdmin = new Role(0L, "ROLE_ADMIN");
        Role roleUser = new Role(1L, "ROLE_USER");

        roleDAO.save(roleAdmin);
        roleDAO.save(roleUser);
        userDAO.save(new User("Василий", "Уткин", 49, "admin@mail.com", passwordEncoder.encode("admin"),
                new HashSet<Role>() {{
                    add(roleAdmin);
                    add(roleUser);
                }}));
        userDAO.save(new User("Дмитрий", "Пупкин", 46, "user@mail.com", passwordEncoder.encode("user"),
                new HashSet<Role>() {{
                    add(roleUser);
                }}));
    }
}