package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {


    Manager manager = new Manager("Great", "0905678", "@gmail");
    Applicant applicantAccept = new Applicant(20, "BSc");
    Applicant applicantReject = new Applicant(15, "JuniorWAEC");


    @Test
    void canHireApplicant() {

        assertEquals(true, manager.canHire(applicantAccept));
        assertEquals(false, manager.canHire(applicantReject));


    }

}




