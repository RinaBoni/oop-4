/**
 * @author Борисова Екатерина ИВТ-20
 */

package com.example.chatbot;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс Bot
 * тут расписана вся работа бота (ответы, запросы)
 */
public class Bot {


    /**
     * Общие фразы (когда написали что-то не понятное)
     */
    private final String[] SIMPLE_PHRASES = {
            "Нет ничего ценнее слов, сказанных к месту и ко времени.",
            "Порой молчание может сказать больше, нежели уйма слов.",
            "Перед тем как писать/говорить всегда лучше подумать.",
            "Вежливая и грамотная речь говорит о величии души.",
            "Приятно когда текст без орфографических ошибок.",
            "Многословие есть признак неупорядоченного ума.",
            "Слова могут ранить, но могут и исцелять.",
            "Записывая слова, мы удваиваем их силу.",
            "Кто ясно мыслит, тот ясно излагает.",
            "Боюсь Вы что-то не договариваете."};


    /**
     * Ответы (когда спросили что-то не понятное)
     */
    private final String[] SIMPLE_ANSWERS = {
            "Вопрос непростой, прошу тайм-аут на раздумья.",
            "Не уверен, что располагаю такой информацией.",
            "Может лучше поговорим о чём-то другом?",
            "Простите, но это очень личный вопрос.",
            "Не уверен, что Вам понравится ответ.",
            "Поверьте, я сам хотел бы это знать.",
            "Вы действительно хотите это знать?",
            "Уверен, Вы уже догадались сами.",
            "Зачем Вам такая информация?",
            "Давайте сохраним интригу?"};


    /**
     * Шаблоны для анализа
     */
    private final Map<String, String> PATTERNS_FOR_ANALYSIS = new HashMap<String, String>() {{
        //привет
        put("хай", "hello");
        put("привет", "hello");
        put("здорово", "hello");
        put("здравствуй", "hello");

        // кто ты
        put("кто\\s.*ты", "who");
        put("ты\\s.*кто", "who");

        // Как зовут
        put("как\\s.*зовут", "name");
        put("как\\s.*имя", "name");
        put("есть\\s.*имя", "name");
        put("какое\\s.*имя", "name");

        // Как дела
        put("как\\s *оно", "howareyou");
        put("как\\s.*дела", "howareyou");
        put("как\\s.*жизнь", "howareyou");

        //Что я делаю
        put("зачем\\s+я\\s.*тут", "whatdoidoing");
        put("зачем\\s+я\\s.*здесь", "whatdoidoing");
        put("что\\s+я\\s.*делаю", "whatdoidoing");
        put("чем\\s+я\\s.*занимаюсь", "whatdoidoing");

        // Что делаешь
        put("зачем\\s.*тут", "whatdoyoudoing");
        put("зачем\\s.*здесь", "whatdoyoudoing");
        put("что\\s.*делаешь", "whatdoyoudoing");
        put("чем\\s.*занимаешься", "whatdoyoudoing");

        //Спасибо
        put("пасибо", "thanks");
        put("пасибки", "thanks");
        put("благодарю", "thanks");
        put("благодарен", "thanks");
        put("от души", "thanks");
        put("спасибо", "thanks");

        //что нравится
        put("что\\s.*нравится", "whatdoyoulike");
        put("что\\s.*любишь", "whatdoyoulike");

        // я чувствую
        put("кажется", "iamfeelling");
        put("чувствую", "iamfeelling");
        put("испытываю", "iamfeelling");

        // Согласие
        put("^да", "yes");
        put("согласен", "yes");

        // Дата и время
        put("который\\s.*час", "whattime");
        put("сколько\\s.*время", "whattime");
        put("время", "whattime");

        // Прощание
        put("прощай", "bye");
        put("увидимся", "bye");
        put("до\\s.*свидания", "bye");
        put("пока", "bye");

        //Запросы в браузер
        put("найди", "search");
        put("найти", "search");
        put("поиск", "search");
        put("поищи", "search");
    }};


    /**
     * Ответы по ключам
     */
    private final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<String, String>() {{
        put("hello", "Здравствуйте, рад Вас видеть.");
        put("who", "Я обычный чат-бот.");
        put("name", "Зовите меня Чаттер :)");
        put("howareyou", "Спасибо, что интересуетесь. У меня всё хорошо.");
        put("whatdoyoudoing", "Я пробую общаться с людьми.");
        put("whatdoidoing", "Ну мне то откуда это знать, это ты должен спросить у себя самого.");
        put("whatdoyoulike", "Мне нравиться думать что я не просто программа.");
        put("iamfeelling", "Как давно это началось? Расскажите чуть подробнее.");
        put("yes", "Согласие есть продукт при полном непротивлении сторон.");
        put("bye", "До свидания. Надеюсь, ещё увидимся.");
        put("thanks", "Да не за что, обращайся.");
    }};


    /**
     * шаблон для поиска
     */
    private Pattern pattern;


    /**
     * чтобы рандомить ответ, если не соответствует шаблону
     */
    private Random random;


    /**
     * Для получения даты
     */
    private Calendar calendar;


    /**
     *результат сравнения
     */
    private Matcher matcher;


    Bot()
    {
        random = new Random();
    }


    /**
     * метод для получения даты и времени
     * @return дата и время
     */
    public String getDate()
    {
        calendar = Calendar.getInstance();  //Получаем дату
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");   //создаем нужный шаблон
        String str = format.format(calendar.getTime()); //форматирует дату в строку
        return str;//возвращаем отформатированную дату
    }


    /**
     * метод для ответа
     * @param question вопрос, фраза или запрос
     * @return  ответ
     * @throws URISyntaxException Проверенное исключение, выданное, чтобы указать, что строка не могла быть проанализирована как ссылка URI.
     * @throws IOException Сигналы, что исключение ввода-вывода некоторого вида произошло.
     *                     Этот класс является общим классом исключений, произведенных отказавшими или прерванными операциями ввода-вывода.
     */
    String answer (String question) throws URISyntaxException, IOException {

        String say;
        if (question.trim().endsWith("?"))       //удаляем начальные и конечные пробелы. проверяем, заканчивается ли на ?
        {
            say = SIMPLE_ANSWERS[random.nextInt(SIMPLE_ANSWERS.length)];    //рандомим ответ
        }
        else
        {
            say = SIMPLE_PHRASES[random.nextInt(SIMPLE_ANSWERS.length)];    //рандомим фразу
        }

        String message = String.join(" ", question.toLowerCase().split("[ {,|.}?]+"));   //переводим в нижний регистр и вырезаем все***

        //Теперь пробежимся по мапам и поищем нужную нам фразу
        for (Map.Entry<String, String> entry: PATTERNS_FOR_ANALYSIS.entrySet())     //entrySet возвращает множество пар (ключ-значение), которые можно перебрать в цикле
        {
            pattern = Pattern.compile(entry.getKey());          //ищем нужный нам шаблон (Компилирует данное регулярное выражение в шаблон. Возвращает ключ, соответствующий этой записи)
            matcher = pattern.matcher(message);                 //matcher вернет true только тогда, когда вся строка соответствует заданному РВ

            if (matcher.find())                //если нашли такой шаблон (find пытается найти подстроку, которая удовлетворяет РВ)
            {
                //Дата и время
                if (entry.getValue().equals("whattime"))        //Если запрос был на время
                {
                    say = getDate();                            //То возвращаем время
                    break;
                }
                //Дата и время
                if (entry.getValue().equals("search"))          //Если запрос был на время
                {
                    Desktop desktop = Desktop.getDesktop();     //Desktop запускает установленный по умолчанию браузер с заданным URI;

                    //Вырезаем сам поисковый запрос
                    String request = message.substring(matcher.end(), message.length());    //request - запрос, end возвращает то что идет после шаблона

                    request = request.replaceAll("\\s+", "+");  //Все пробелы заменяем +

                    desktop.browse(new URI("https://yandex.ru/search/?text=" + request));  //Открываем браузер с запросом

                    say = getDate();                           //возвращаем время (просто по тому что метод answer должен вернуть say
                    break;
                }
                say = ANSWERS_BY_PATTERNS.get(entry.getValue());   //обращаемся по найденному к ответам
            }
        }
        return say;
    }
}
