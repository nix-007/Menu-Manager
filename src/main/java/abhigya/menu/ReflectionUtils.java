package abhigya.menu;

public class ReflectionUtils {

    public static final String CRAFT_CLASSES_PACKAGE = "org.bukkit.craftbukkit.";

    /**
     * Gets a class within the craftbukkit package ({@value #CRAFT_CLASSES_PACKAGE})
     * or within a sub-package of it.
     * <p>
     *
     * @param name         Name of the class to get
     * @param package_name Name of the sub-package or null if the class is not
     *                     within a sub-package
     * @return Class with the provided name
     * @throws ClassNotFoundException if the class doesn't exist
     */
    public static Class<?> getCraftClass(String name, String package_name) throws ClassNotFoundException {
        return Class.forName(CRAFT_CLASSES_PACKAGE + Version.getServerVersion().name() + "."
                + (StringUtils.isBlank(package_name) ? "" : package_name.toLowerCase() + ".") + name);
    }

    /**
     * Returns the enum constant of the specified enum type with the specified name.
     * The name must match exactly an identifier used to declare an enum constant in
     * this type. (Extraneous whitespace characters are not permitted.)
     * <p>
     * Note that for a particular enum type {@code T}, the implicitly declared
     * {@code public static T valueOf(String)} method on that enum may be used
     * instead of this method to map from a name to the corresponding enum constant.
     * All the constants of an enum type can be obtained by calling the implicit
     * {@code public static T[] values()} method of that type.
     * <p>
     *
     * @param <T>   The enum type whose constant is to be returned
     * @param clazz {@code Class} object of the enum type from which to return a
     *              constant
     * @param name  Name of the constant to return
     * @return Enum constant of the specified enum type with the specified name,
     * or null if doesn't exist
     */
    public static <T extends Enum<T>> T getEnumConstant(Class<T> clazz, String name) {
        try {
            return Enum.valueOf(clazz, name);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

}
