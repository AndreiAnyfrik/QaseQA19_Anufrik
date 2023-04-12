package by.teachmeskills;

import by.teachmeskills.page.ProjectPage;
import org.testng.annotations.Test;

public class ProjectTest {
    @Test
    public void check() {
      new  ProjectPage().open();
    }
}
