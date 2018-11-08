import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import static org.telegram.abilitybots.api.objects.Flag.NONE;
import static org.telegram.abilitybots.api.objects.Flag.PHOTO;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.ADMIN;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class MyBot extends AbilityBot {

    protected MyBot(String botToken, String botUsername) {
        super(botToken, botUsername);

    }

    protected MyBot(String botToken, String botUsername, DefaultBotOptions options) {
        super(botToken, botUsername, options);

        SendMessage snd = new SendMessage();
        snd.setChatId(Configuration.ID_CHAT);
        snd.setText("Hello world!");


        try {
            execute(snd);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public int creatorId() {
        return 0;
    }

    public Ability hello() {
        return Ability.builder()
                .name("test")
                .info("hello bot")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("hello!", ctx.chatId()))
                .build();
    }


}