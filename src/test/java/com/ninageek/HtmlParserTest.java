package com.ninageek;

import com.ninageek.HtmlParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlParserTest {
    private static final String HTML = "<!DOCTYPE html><html><head><title>NinaGeek</title><link rel=\"stylesheet\" href=\"/css/materialize.css\"><link rel=\"stylesheet\" href=\"/css/style.css\"><link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\"><script src=\"/js/materialize.js\"><link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/apple-touch-icon.png\"><link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"/favicon-32x32.png\"><link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"/favicon-16x16.png\"><link rel=\"manifest\" href=\"/site.webmanifest\"><link rel=\"mask-icon\" href=\"/safari-pinned-tab.svg\" color=\"#5bbad5\"><meta name=\"apple-mobile-web-app-title\" content=\"NinaGeek\"><meta name=\"application-name\" content=\"NinaGeek\"><meta name=\"msapplication-TileColor\" content=\"#00aba9\"><meta name=\"theme-color\" content=\"#ffffff\"></script></head><body><header><nav class=\"blue-grey darken-1b\"><div class=\"nav-wrapper\"><a class=\"brand-logo my-logo\" href=\"/\">NinaGeek</a></div></nav></header><main><h1>Welcome to NinaGeek</h1><div class=\"row\"><div class=\"col s6\"><div class=\"card hoverable\"><div class=\"card-image\"><img src=\"images/Fuji.jpg\"><span class=\"card-title\">Fuji</span></div><div class=\"card-content\"><p>My name is Nina.I'm learning how to code.</p></div></div><!-- Grey navigation panel--></div><div class=\"col s6\"><div class=\"card hoverable blue-grey darken-1\"><div class=\"card-content white-text\"><span class=\"card-title\">My projects</span></div><div class=\"card-action\"><a href=\"/my-projects\">my projects</a></div></div><div class=\"card hoverable blue-grey darken-1\"><div class=\"card-content white-text\"><span class=\"card-title\">My GitHub</span></div><div class=\"card-action\"><a href=\"https://github.com/ninageek\">The new one</a><a href=\"https://github.com/Never2l8\">The old one</a></div></div><div class=\"card hoverable blue-grey darken-1\"><div class=\"card-content white-text\"><span class=\"card-title\">Contact me</span></div><div class=\"card-action\"><a href=\"https:/t.me/NinaGeek\">Telegram</a><a href=\"#\">E-mail</a></div></div></div></div></main></body></html>";
    private static final String TEXT = "NinaGeek NinaGeek Welcome to NinaGeek Fuji My name is Nina.I'm learning how to code. My projects my projects My GitHub The new one The old one Contact me Telegram E-mail";
    private static final String SCRIPT_TEXT = "<div>content</div><script>some js</script>";
    private static final String NO_SCRIPT_TEXT = "<div>content</div></script>";
    HtmlParser parse = new HtmlParser();

    @Test
    public void getParseHtmlTest() {
        String text = parse.parseHtml(HTML);
        assertEquals(TEXT, text);
    }

    @Test
    public void removeScriptTest() {
        String text = parse.removeScript(SCRIPT_TEXT);
        assertEquals(NO_SCRIPT_TEXT, text);
    }
}
