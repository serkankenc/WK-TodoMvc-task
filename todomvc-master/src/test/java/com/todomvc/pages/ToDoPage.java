package com.todomvc.pages;

import com.todomvc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoPage {

    public ToDoPage(){ PageFactory.initElements(Driver.get(), this);}

    @FindBy(xpath = "//input[starts-with(@placeholder, 'What')]")
    public WebElement textBox;

    @FindBy(xpath = "(//button[@class='destroy'])[1]")
    public WebElement destroy;

    @FindBy(xpath = "//input[@class='toggle']")
    public WebElement toggle;

    @FindBy(xpath = "(//input[@class='toggle'])[2]")
    public WebElement toggle2;

    @FindBy(xpath = "//button[@class='clear-completed']")
    public WebElement clearCompleted;

    @FindBy(xpath = "//div[@class='view']/label")
    public WebElement listContent;

    @FindBy(xpath = "//input[@class='edit']")
    public WebElement editBox;

    @FindBy(xpath = "//span[@class='todo-count']/strong")
    public WebElement itemNumber;

    @FindBy(css = "input.toggle~label")
    public WebElement editedTask;
}


