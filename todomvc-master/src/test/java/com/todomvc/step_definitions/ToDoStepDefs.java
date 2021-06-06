package com.todomvc.step_definitions;

import com.todomvc.pages.ToDoPage;
import com.todomvc.utilities.BrowserUtils;
import com.todomvc.utilities.ConfigurationReader;
import com.todomvc.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class ToDoStepDefs {
    ToDoPage toDoPage = new ToDoPage();
    String itemNumberBefore;
    String itemNumberAfter;
    String itemNegBefore;
    String itemNegAfter;

    /*******************************************************
     *************** Positive Scenario 1 ********************
     *******************************************************/

    @Given("the user is on the To Do page")
    public void the_user_is_on_the_To_Do_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @Given("the user writes tasks to do")
    public void the_user_writes_task_to_do() {
        toDoPage.textBox.sendKeys("wake");
        BrowserUtils.waitFor(2);
        toDoPage.textBox.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);

        toDoPage.textBox.sendKeys("pick");
        BrowserUtils.waitFor(2);
        toDoPage.textBox.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);

        toDoPage.textBox.sendKeys("make");
        BrowserUtils.waitFor(2);
        toDoPage.textBox.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);

    }

    @When("the user add new task")
    public void the_user_add_new_task() {
        itemNumberBefore = toDoPage.itemNumber.getText();
        System.out.println("item number before: " + itemNumberBefore);
        toDoPage.textBox.sendKeys("last task");
        toDoPage.textBox.sendKeys(Keys.ENTER);
        itemNumberAfter = toDoPage.itemNumber.getText();
        System.out.println("item number after: " + itemNumberAfter);
        BrowserUtils.waitFor(2);
    }

    @Then("the new task is added on the list")
    public void the_new_task_is_added_on_the_list() {
        Assert.assertNotEquals(itemNumberBefore,itemNumberAfter);
    }

    /********************************************************
     *************** Negative Scenario 1 ********************
     *******************************************************/

    @When("the user put space, blank")
    public void the_user_put_space_blank() {
        itemNegBefore = toDoPage.itemNumber.getText();
        System.out.println("item negative number before: " + itemNegBefore);
        toDoPage.textBox.sendKeys("   ");
        BrowserUtils.waitFor(2);
        toDoPage.textBox.sendKeys(Keys.ENTER);
        itemNegAfter = toDoPage.itemNumber.getText();
        System.out.println("item negative number after: " + itemNegAfter);

        BrowserUtils.waitFor(2);
    }

    @Then("the task is not added on the list")
    public void the_task_is_not_added_on_the_list() {
        Assert.assertEquals(itemNegAfter,itemNegBefore);
    }

    /*******************************************************
     *************** Positive Scenario 2 ********************
     *******************************************************/

    @Given("the user edits existing task")
    public void the_user_edits_existing_task() {

        Actions action = new Actions(Driver.get());
        action.doubleClick(toDoPage.listContent).perform();
        toDoPage.editBox.click();
        BrowserUtils.waitFor(3);
        toDoPage.editBox.clear();
        BrowserUtils.waitFor(3);
        action.doubleClick(toDoPage.editedTask).perform();
        action.doubleClick(toDoPage.editBox).perform();
        toDoPage.editBox.sendKeys("edited");
        BrowserUtils.waitFor(3);
        toDoPage.editBox.sendKeys(Keys.ENTER);
    }

    @Then("the existing task in the list is edited")
    public void the_existing_task_in_the_list_is_edited() {
        String expectedResult = "edited";
        String actualResult = toDoPage.listContent.getText();
        System.out.println("expected Result: " + expectedResult);
        System.out.println("actual Result: " + actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }

    /*******************************************************
     *************** Negative Scenario 2 *******************
     ******************************************************/

    @When("the user does not edit existing task")
    public void the_user_does_not_edit_existing_task() {
        //no action required
    }

    @Then("the existing task in the list is not changed")
    public void the_existing_task_in_the_list_is_not_changed() {
        String expectedResult = "wake";
        String actualResult = toDoPage.listContent.getText();
        System.out.println("expectedResult = " + expectedResult);
        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }

    /*******************************************************
     *************** Positive Scenario 3 ********************
     *******************************************************/

    @When("the user delete existing task in the list")
    public void the_user_delete_existing_task_in_the_list() {
        itemNumberBefore = toDoPage.itemNumber.getText();
        System.out.println("item number before: " + itemNumberBefore);
        Driver.get().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        toDoPage.toggle.click();
        BrowserUtils.waitFor(2);
        toDoPage.destroy.click();
        itemNumberAfter = toDoPage.itemNumber.getText();
        System.out.println("item number after: " + itemNumberAfter);

        BrowserUtils.waitFor(2);
    }

    @Then("the existing task in the list is deleted")
    public void the_existing_task_in_the_list_is_deleted() {
        Assert.assertNotEquals(itemNumberBefore,itemNumberAfter);
    }

    /*******************************************************
     *************** Negative Scenario 3 ********************
     *******************************************************/

    @When("the user do not delete existing task in the list")
    public void the_user_do_not_delete_existing_task_in_the_list() {
        itemNumberBefore = toDoPage.itemNumber.getText();
        System.out.println("item number before: " + itemNumberBefore);

        //if the user does not select any completed task to delete, to do list will be remained without changing.
    }

    @Then("the number of existing tasks are not changed")
    public void the_number_of_existing_tasks_are_not_changed() {
         String expectedResult = itemNumberBefore;
         String actualResult = toDoPage.itemNumber.getText();
         Assert.assertEquals(expectedResult,actualResult);
    }

    /*******************************************************
     *************** Positive Scenario 4 ********************
     *******************************************************/

    @When("the user chooses task he or she wants to delete")
    public void the_user_chooses_task_he_or_she_wants_to_delete() {
        itemNumberBefore = toDoPage.itemNumber.getText();
        System.out.println("item number before: " + itemNumberBefore);
        toDoPage.toggle.click();
        BrowserUtils.waitFor(3);
        toDoPage.toggle2.click();
        BrowserUtils.waitFor(3);
    }

    @When("the user delete chosen tasks in the list")
    public void the_user_delete_chosen_tasks_in_the_list() {

        toDoPage.clearCompleted.click();

        itemNumberAfter = toDoPage.itemNumber.getText();
        System.out.println("item number after: " + itemNumberAfter);

        BrowserUtils.waitFor(2);
    }

    @Then("the chosen multiple tasks are removed")
    public void the_chosen_multiple_tasks_are_removed() {
        Assert.assertNotEquals(itemNumberBefore,itemNumberAfter);
    }

    /*******************************************************
     *************** Negative Scenario 4 ********************
     *******************************************************/


    @When("the user does not choose any task to delete")
    public void the_user_does_not_choose_any_task_to_delete() {
        itemNumberBefore = toDoPage.itemNumber.getText();
        System.out.println("item number before: " + itemNumberBefore);

        //if the user does not select any completed task to delete, to do list will be remained without changing.
    }

}
