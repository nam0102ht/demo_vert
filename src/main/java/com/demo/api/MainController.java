package com.demo.api;

import com.demo.model.Article;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class MainController {

    public void getArticle(RoutingContext routingContext) {
        String articleId = routingContext.request()
                .getParam("id");
        Article article = new Article(articleId,
                "This is an intro to vertx", "baeldung", "01-02-2017", 1578);

        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(article));
    }
}
