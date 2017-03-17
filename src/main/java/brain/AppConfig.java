package brain;

import brain.models.QAText;
import brain.models.Question;
import brain.models.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import brain.repositories.QARepository;
import brain.repositories.impl.QARepositoryMapImpl;
import brain.service.SentenceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/17/17.
 */
@Configuration
public class AppConfig {

    @Autowired
    SentenceService sentenceService;

    @Bean
    public QARepository qaRepository() {
        QARepository qaRepository = new QARepositoryMapImpl();

        List<QAText> qaTexts = initQAList();

        qaTexts.forEach(qaText -> {
            QuestionAnswer qa = new QuestionAnswer();
            Question q = sentenceService.processQuestion(qaText.getQuestion());
            qa.setQuestion(q);
            qa.setAnswerText(qaText.getAnswer());
            qaRepository.insertQuestionAnswer("UoT", qa);
        });
        return qaRepository;
    }


    public static List<QAText> initQAList() {
        List<QAText> qaTexts = new ArrayList<>();

        qaTexts.add(new QAText("What are the admission requirements?", "Master's Programs and Full-Time Special Students\n" +
        "\n" +
        "\u200Ban appropriate bachelor's degree, or its equivalent, with a final year average of at least mid-B from a recognized university\n" +
        "\n" +
        "Doctoral Programs\n" +
        "\n" +
        "\u200Ban appropriate master's degree, or its equivalent, with an average of at least B+ or demonstrated comparable research competence\n" +
        "\n" +
        "Many graduate units have higher minimum requirements than the minimum SGS requirements. As we receive many more applications each year from excellent candidates than we have placements available, meeting the minimum admissions requirement does not necessarily guarantee admission.\n" +
        "\n" +
        "The minimum admissions requirements set by SGS can also be found on the Admissions page."));

        qaTexts.add(new QAText("What is an appropriate bachelor's degree?", "An appropriate admitting degree is one that satisfies the following criteria:\n" +
        "\n" +
        "a) the issuing institution must be recognized as having degree granting authority by the appropriate jurisdictional authorities (e.g. Provincial / Territorial government or regional quality assurance body);\n" +
        "\n" +
        "b) the degree must be the standard first entry degree which gives access to advanced research-based graduate programs in the country of origin (e.g. This is typically four years in North America or a three-year Bologna compliant degrees. Please consult the SGS International Equivalencies Database for more information.); and\n" +
        "\n" +
        "c) where appropriate, have the required affinity or programmatic fit to the graduate program to which you are seeking admission.\n" +
        "\n" +
        "All admission decisions are made on a case-by-case basis and are based on a composite of information which may include previous academic performance, comments from referees, relevant professional activities, proposed research statements, correspondence between research interests and available faculty expertise and in some programs, standardized test scores. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("Are three-year Bologna compliant degrees acceptable?", "Qualified applicants with three-year Bologna-compliant bachelor's degrees (except three-year UK degrees preceded by the GCE A-levels which are considered equivalent) are considered admissible and are encouraged to apply. In addition to the SGS minimum admission requirements, there are several factors that will be taken into consideration while assessing these degrees: requirements for gaining admission to the degree; content of the degree and duration of the degree, among others. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("I have a four-year Bachelor's degree from a community college. Will it be acceptable?", "Applications to graduate studies at U of T from graduates of four-year community college bachelor's programs are considered admissible and are encouraged to apply. In addition to the SGS minimum admission requirements, there are several factors that will be taken into consideration while assessing these degrees: the degree of affinity between the applied degree and the program to which the applicant is seeking admission; the academic content of the third and fourth year courses; and other indicators that the applicant is adequately prepared for independent research which is a distinctive characteristic of every graduate degree. The degree program should be normally comprised of at least 75% liberal arts and science content. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("Can I apply to a PhD program directly from a bachelor's degree?", "Some graduate \u200Bunits will allow direct entry to a PhD program from a bachelor's degree for exceptional applicants. Such applicants require an appropriate Bachelor's degree, or equivalent, with an average of at least A-.\n" +
        "\n" +
        "For more information, contact the department to which you are applying."));

        qaTexts.add(new QAText("I am an international applicant. How do I know if you recognize my degree?", "Please consult our International Degree Equivalencies directory. If your degree is not listed there, you may wish to contact us for confirmation.\n" +
        "\n" +
        "Note that we will not review or assess your academic record without an official application to a graduate degree program at the University of Toronto, including payment of the appropriate application fee. Prior to application, we are able to confirm if the degree you have received is considered equivalent to our minimum admission requirements. If you do need to email us to inquire about your specific degree, please be sure to include the country and university in which it was earned, and the full official name of the credential awarded, with date of award and length of study period."));

        qaTexts.add(new QAText("Do I need to take the GRE exam?", "Although most of our graduate units do not require a GRE exam, there are some that do. Other departments encourage international applicants, in particular, to consider taking the GRE as this assists them in making a fair assessment of your preparation for graduate study. Please check the graduate unit’s instructions to see if the GRE is required in your case."));

        qaTexts.add(new QAText("How much is the application fee?", "A $120 CDN application fee is required. This fee is non-refundable and non-transferable. A supplementary application fee may be assessed depending upon the program to which you are applying. The supplementary application fee can be found at the program's website or at the payment step of the online application."));

        return qaTexts;

    }

}