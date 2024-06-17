package assignment1706.nhattruong.config;

import assignment1706.nhattruong.annotation.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(path = "src/main/resources/assignment1706.properties")
public class DatasourceProperties {
    public static void main(String[] args) {
        Class<?> clazz = DatasourceProperties.class;
        ConfigurationProperties config = clazz.getAnnotation(ConfigurationProperties.class);
    }
    private String name;
    private String password;
}