package ru.job4j.articles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;
import ru.job4j.articles.service.ArticleService;
import ru.job4j.articles.service.SimpleArticleService;
import ru.job4j.articles.service.generator.ArticleGenerator;
import ru.job4j.articles.service.generator.RandomArticleGenerator;
import ru.job4j.articles.store.ArticleStore;
import ru.job4j.articles.store.Store;
import ru.job4j.articles.store.WordStore;

import java.io.InputStream;
import java.util.Properties;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class.getSimpleName());

    public static final int TARGET_COUNT = 1_000_000;

    public static void main(String[] args) throws Exception {
        Properties properties = loadProperties();
        Store<Word> wordStore = new WordStore(properties);
        Store<Article> articleStore = new ArticleStore(properties);
        ArticleGenerator articleGenerator = new RandomArticleGenerator();
        ArticleService articleService = new SimpleArticleService(articleGenerator);
        articleService.generate(wordStore, TARGET_COUNT, articleStore);
    }

    private static Properties loadProperties() {
        LOGGER.info("Загрузка настроек приложения");
        Properties properties = new Properties();
        try (InputStream in = Application.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(in);
        } catch (Exception e) {
            LOGGER.error("Не удалось загрузить настройки. { }", e.getCause());
            throw new IllegalStateException();
        }
        return properties;
    }

}
