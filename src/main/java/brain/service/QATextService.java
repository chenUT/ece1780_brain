package brain.service;

import brain.models.QAText;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 3/20/17.
 */
@Service
public class QATextService {

    private List<QAText> qaTexts;

    public QATextService() {
        this.qaTexts = initQAList();
    }

    public List<QAText> getQATextList() {
        return this.qaTexts;
    }

    public void addQAText(QAText qaText){
        this.qaTexts.add(qaText);
    }

    public List<QAText> getQaTexts(){
        return this.qaTexts;
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

        qaTexts.add(new QAText("I am an international applicant. How do I know if you recognize my degree?", "Please consult our International Degree Equivalencies directory. If your degree is not listed there, you may wish to contact us for confirmation."));

        qaTexts.add(new QAText("When should I apply?", "Application deadlines vary from program to program. Please visit the program's admission requirements page or contact the graduate unit for the exact date."));

        qaTexts.add(new QAText("I might miss the application deadline; can I have an extension?", "All applications should be received by the application deadlines which are set by individual programs. Please contact the program you wish to apply to for approval to apply after the deadline.\n" +
        "\n" +
        "If you have missed the application deadline, you cannot submit an online application until you have received approval from the specific program."));

        qaTexts.add(new QAText("I would like to apply to a graduate school at the University of Toronto. Where should I get the application form?", "To apply to a graduate program, you must complete the online admissions application form available from the program's admission requirements page. Please carefully read the instructions, requirements and deadlines provided by the program's website as the application fee is non-refundable."));

        qaTexts.add(new QAText("Will you accept my application and supporting documents prepared and submitted by an agent or consultant?", "The University of Toronto does not have any financial arrangements or special relationship with any agents who assist in the preparation and submission of a graduate application for a fee. You are required to complete and submit your own application and must provide your own personal details. All of the information necessary to complete an application to any graduate program is available on the program's admission requirements website.\u200B"));

        qaTexts.add(new QAText("I don't have an access to the Internet; can I get a paper application form?", "If you do not have access to the Internet, please contact the graduate unit for an alternative method of applying."));

        qaTexts.add(new QAText("Do I have to list all the schools and institutions I have attended?", "Yes. It is required that you list all post-secondary institutions you have attended. You do not need to submit any information or documents related to high school."));

        qaTexts.add(new QAText("I want to apply to more than one program; do I have to submit more than one application?", "You will be assigned an applicant number and password when you start the SGS online application. If you plan to apply to more than one program, you can add a new application from the payment section of the online application.\u200B\n"));

        qaTexts.add(new QAText("How much is the application fee?", "A $120 CDN application fee is required. This fee is non-refundable and non-transferable. A supplementary application fee may be assessed depending upon the program to which you are applying. The supplementary application fee can be found at the program's website or at the payment step of the online application."));

        qaTexts.add(new QAText("How should I pay the application fee?", "\u200BPayment is made at the time of application online using a credit only a Visa or Mastercard credit card.\u200B  Applications will not be processed unless the application fee is received."));

        qaTexts.add(new QAText("Can my application fee be waived?\u200B", "No."));

        qaTexts.add(new QAText("I changed my mind and do not want to go to graduate school anymore; can I get a refund of the application fee?", "There is no refund, waiver, or deferral of the application fee.\u200B"));

        qaTexts.add(new QAText("How should my academic transcripts be submitted?", "Applicants should ask each university attended to send their academic transcripts directly to the department (graduate unit) to which they are applying in a sealed and, preferably signed envelope. The envelope should be signed and stamped by the registrar or by an authorized official of your school/college/university.\n" +
        "\n" +
        "Do not send transcripts to the School of Graduate Studies."));

        qaTexts.add(new QAText("My institution will release transcripts to me but not to the institution to which I am applying. Will you accept transcripts submitted by me?\n" +
        "\n", "If the institution will only release the verification to you, please request that they are sent in a sealed envelope so that you can forward that envelope directly to the graduate unit. Do not open the envelope as that will void the verification. The documents must be received in the original sealed envelope to be considered official.\n" +
        "\n"));

        qaTexts.add(new QAText("My transcript does not include course title or grades. What should I do?", "You should provide the graduate unit with course descriptions and/or an official statement of academic standing from an appropriate academic officer of the institution concerned."));

        qaTexts.add(new QAText("What do I do if my educational institution has closed?", "If the school(s) you attended is no longer in existence, or if it is impossible to obtain official documents from any school(s), you should ask the Ministry of Education in the country in which the credential was awarded to furnish an official statement testifying to the impossibility of obtaining records. The Ministry should also be requested to supply the graduate unit at the University of Toronto with a list of courses taken and grades received by the applicant in that school or university."));

        qaTexts.add(new QAText("I have not completed my current degree yet; what should I do?", "If you have not completed your bachelor’s degree (or master’s degree if applicable) at the time you apply to the University of Toronto, please request transcripts from your university showing the work you have completed to date. Please indicate the date when the final result will be available. If you are issued an admissions offer based upon your course work to date, all degree requirements must be completed prior to registration and a final transcript must be received by your graduate unit indicating the date of conferral of your degree."));

        qaTexts.add(new QAText("My name in my official transcripts is different from my passport/other transcripts; shall I provide a document explaining the discrepancy?", "Yes. In case the names differ, you must provide original documentation of your name change, such as marriage certificate or a notarized name change certificate to SGS Student Services."));

        qaTexts.add(new QAText("My academic records are in a language other than English. Shall I also submit English translations of my documents?", "Certified English translations are required for all international documentation written in a language other than English or French. SGS does not recommend translators but the translator must be certified. Translations do not replace original documentation. Both the original documents and translations must be submitted."));

        qaTexts.add(new QAText("My transcripts are in French. Shall I submit English translations?", "French and English are both official languages of Canada. We therefore do not request English translations of transcripts written in French."));

        qaTexts.add(new QAText("Can I get my transcripts back?", "Once supporting documents are submitted they become the property of the University of Toronto and cannot be returned.\u200B"));

        qaTexts.add(new QAText("How many reference letters are required for admission?", "SGS requires two letters of reference; however, you should review your program-specific list of admission requirements to determine if additional letters of reference are required."));

        qaTexts.add(new QAText("What is the process for referees?", "Applicants will need to enter referees’ names and (institutional) email addresses into their online application. The system will automatically email an electronic submission request to each referee when the application fee is paid. Although you will provide the referee information before payment, the system will not notify your referees until after you have paid the application fee. It is highly recommended that applicants contact their referees ahead of time to check their availability."));

        qaTexts.add(new QAText("My referee did not receive the email from the School of Graduate Studies. Could you please resend it?\n", "Referees are advised to check their junk mail folder or that they do not have a pop-up blocker installed. If they still do not have the letter, you can resend the request email from the supporting documents section of your application. If you have entered your referee's address incorrectly, please contact the graduate unit you are applying to for help making the correction."));

        qaTexts.add(new QAText("Is the recommendation deadline the same as the application deadline?", "Some graduate units have separate deadlines for applicants and referees.Referees should submit their recommendations by the deadline specified in the reference request email they receive from the School of Graduate Studies. "));

        qaTexts.add(new QAText("The contact information of my referee has been changed. As I have already submitted the online application how can I edit the referee's contact information?", "As you have already submitted your online application and paid the appropriate application fee, you cannot make any changes to your application, except your own contact information (address). Therefore, if you need to update the contact information of your referee, you should contact the graduate unit and provide them with the required information."));

        qaTexts.add(new QAText("How do I know when the graduate unit received my supplemental materials?", "Applicants may monitor the status of their application by logging into the online application. Once you have mailed your supporting documents, please allow two to three weeks from the time you submit your application for your account to reflect receipt of these materials."));

        qaTexts.add(new QAText("Where do I send my application supporting documents?", "Applicants should make sure that all supporting documents are sent to the graduate units they are applying to.\u200B"));

        qaTexts.add(new QAText("English is not my first language. Do I need to take the TOEFL/TWE exam?", "If your primary language is not English and you graduated from a non-Canadian university where the language of instruction and examination was not English, then you must demonstrate your facility in English by successfully completing an acceptable English language proficiency test. This requirement should be met at the time you submit your application, and must be met before registration is allowed. The TOEFL is just one of the m any tests that we accept. For more information, including minimum required scores, please see the English Language Proficiency Testing page.\u200B"));

        qaTexts.add(new QAText("Where can I get an application form for financial aid?", "There is no separate application for funding. Applicants will automatically be considered for any available funding for which you are eligible. If you are pursuing a doctoral-stream degree, the University of Toronto has a guaranteed minimum funding package of at least $15,000 plus tuition and fees for up to five years. Some departments may offer packages above the guaranteed minimum. The funding package may include: internal awards, external awards, teaching assistantships, or research assistantships.\n" +
        "Applicants are strongly encouraged to apply for external awards for which they may be eligible well in advance of applying for admission. For more information on graduate awards visit Financing Your Graduate Education."));

        qaTexts.add(new QAText("Where can I get information on the status of my application?", "You can log in to the Online Application for information on the status of your application. You will need to use your Applicant Number and password assigned to you by the School of Graduate Studies."));

        qaTexts.add(new QAText("When will I hear a decision on my application?", "This varies by graduate unit, and is affected by the volume of applications received. Some early offers of admission are sent out in January or February; however, the majority of offers normally come in March. SGS generally advises applicants to expect a response by April, although decisions continue to be made after this point."));

        qaTexts.add(new QAText("I sent my application but I have not heard back from the graduate unit. How do I know my application and supporting documents have been received?", "Graduate units do not normally confirm the receipt of applications. You are responsible to ensure that you have read and understood the application requirements for that graduate unit, and that you have gathered all the necessary components of your application package. You can check the receipt status of your documents by logging into the Online Application and viewing the details of your application. A delay can be expected between the time of receipt and when the status is updated."));

        qaTexts.add(new QAText("The status of my online application is indicated as \"Documents pending\"; however, I am sure that all my supporting documents have been submitted.", "Every document submitted by mail by an applicant has to be entered onto the system by a graduate administrator. There is necessarily a time lag between the receipt of documents and the uploading of that information onto the Online Application system. However, an applicant needs to contact the department w here s/he has mailed the documents directly and inquire if all documents have been received."));

        qaTexts.add(new QAText("Will the School of Graduate Studies provide feedback for students who have been rejected?", "The School of Graduate Studies oversees the graduate admissions process and sets minimum admission requirements for all graduate programs at the University of Toronto, however, admission decisions are made locally at the departmental level.\n" +
        "\n" +
        "Due to the large number of applications graduate units receive each year, we unfortunately cannot accommodate requests for personalized feedback on your application. Admission to University of Toronto is very competitive and students who meet, and even exceed, our minimum requirements may not necessarily receive an offer.\u200B"));

        qaTexts.add(new QAText("I have been admitted; however, I have a few questions before I make the final decision. Who do I need to contact?", "You should contact the graduate unit from which you have got your acceptance letter. The graduate administrator of your program will be able to answer your questions."));

        qaTexts.add(new QAText("May I defer admission to the University of Toronto?", "With departmental approval, you could defer admission for up to 12 months. Admitted applicants who accept an offer of admission are expected to enrol in the term for which they applied and were admitted.\u200B\u200B \n" +
        "\n"));

        qaTexts.add(new QAText("I have a four-year Bachelor's degree from a community college. Will it be acceptable?", "Applications to graduate studies at U of T from graduates of four-year community college bachelor's programs are considered admissible and are encouraged to apply. In addition to the SGS minimum admission requirements, there are several factors that will be taken into consideration while assessing these degrees: the degree of affinity between the applied degree and the program to which the applicant is seeking admission; the academic content of the third and fourth year courses; and other indicators that the applicant is adequately prepared for independent research which is a distinctive characteristic of every graduate degree. The degree program should be normally comprised of at least 75% liberal arts and science content. Eligibility cannot be determined until a complete application is submitted."));

        qaTexts.add(new QAText("Can I apply to a PhD program directly from a bachelor's degree?", "Some graduate \u200Bunits will allow direct entry to a PhD program from a bachelor's degree for exceptional applicants. Such applicants require an appropriate Bachelor's degree, or equivalent, with an average of at least A-.\n" +
        "\n" +
        "For more information, contact the department to which you are applying."));

        qaTexts.add(new QAText("Do I need to take the GRE exam?", "Although most of our graduate units do not require a GRE exam, there are some that do. Other departments encourage international applicants, in particular, to consider taking the GRE as this assists them in making a fair assessment of your preparation for graduate study. Please check the graduate unit’s instructions to see if the GRE is required in your case."));

        return qaTexts;
    }
}
