package me.shaposhnikandrii.httptoilet.config;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.Properties;

import static java.lang.Thread.currentThread;

public class AppConfig extends AbstractModule {

  @Provides @Singleton
  public Properties provideApplicationProperties() {
    try {
      final InputStream is = currentThread().getContextClassLoader().getResourceAsStream("application.properties");

      final Properties properties = new Properties();
      properties.load(Objects.requireNonNull(is));

      return properties;
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Provides @Named("port")
  public int providePort(Properties properties) {
    return Integer.parseInt(properties.getProperty("server.port"));
  }

  @Provides @Singleton
  public Gson provideGson() {
    return new Gson();
  }
}
