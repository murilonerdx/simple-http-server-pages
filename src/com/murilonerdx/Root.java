package com.murilonerdx;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Esta classe é responsável por gerenciar as requisições http feitas no
 * contexto /
 *
 * @author Murilo Pereira
 */
public class Root implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {

        String saida = "<html>" +
                "<head>" +
                "<h1>e-mail: <span style='color: red;'> mu-silva@outlook.com</span>" + "</h1>" +
                "</head>" +
                "<body>" +
                "<h1 style='color: blue'>Esté é um site baseado em abertura de socket e também rotas.</h1>" +
                "</body>" +
                "</html>";

        he.sendResponseHeaders(200, saida.length());

        try (OutputStream os = he.getResponseBody()) {
            os.write(saida.getBytes(StandardCharsets.ISO_8859_1));
        }
    }

}
