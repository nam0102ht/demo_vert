package com.demo.router;

import com.demo.api.MainController;
import io.vertx.ext.web.Router;

public class MainRouter {
    public void main(Router route) {
        MainController main = new MainController();
        route.get("/api/demo/articles/article/:id").handler(main::getArticle);
    }
}
