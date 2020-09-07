package com.demo;

import com.demo.router.MainRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import com.demo.api.MainController;

public class Server extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);
        MainRouter mainRoute = new MainRouter();
        mainRoute.main(router);
        vertx.createHttpServer().requestHandler(router)
                .listen(config().getInteger("http.port", 8000), result -> {
                    if(result.succeeded()) {
                        System.out.println("Server is starting listen port 8080");
                        startPromise.complete();
                    } else {
                        System.out.println("Can't init server");
                        startPromise.fail(result.cause());
                    }
                });
    }

    @Override
    public void stop(Promise<Void> stopPromise) throws Exception {
        System.out.println("Shutting down server");
    }

    public static void main(String [] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Server());
    }
}
