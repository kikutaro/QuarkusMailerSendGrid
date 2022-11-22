package tech.kikutaro;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import io.quarkus.mailer.Mailer;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

@Path("/form")
public class FormResource {
    @Inject Mailer mailer;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String form(@RestForm String email) {

        mailer.send(Mail.withText(email, "お問合せを受け付けました", "ほげほげ"));

        System.out.println(email);
        return "登録を受け付けました。メールをご確認ください。";
    }
}