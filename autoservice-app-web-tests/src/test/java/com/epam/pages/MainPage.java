package com.epam.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public static final String VAADIN_BUTTON_SELECTOR = "vaadin-button";
    private ElementsCollection listOfOrders = $$("vaadin-grid-cell-content");
    private SelenideElement searchInput = $("vaadin-text-field");
    private SelenideElement searchButton = $(VAADIN_BUTTON_SELECTOR);
    private SelenideElement addButton = $$(VAADIN_BUTTON_SELECTOR).get(1);
    private SelenideElement ownerNameInput = $$("vaadin-text-field").get(3);
    private SelenideElement saveButton = $$(VAADIN_BUTTON_SELECTOR).get(3);
    private SelenideElement cancelButton = $$(VAADIN_BUTTON_SELECTOR).get(2);
    private SelenideElement deleteButton = $$(VAADIN_BUTTON_SELECTOR).get(4);

    public void checkResultsSizeIsAtLeast(int expectedSize) {
        listOfOrders.shouldHave(sizeGreaterThan(expectedSize));
    }

    public void searchOrderById(String orderId) {
        searchInput.sendKeys(orderId);
        searchButton.click();
    }

    public void checkedOrderId() {
        listOfOrders.get(1).shouldHave(Condition.text("1"));
    }

    public void addNewOrder(String ownerName) {
        addButton.shouldHave(Condition.text("Add new")).click();
        ownerNameInput.sendKeys(ownerName);
    }

    public void clickSave() {
        saveButton.shouldHave(Condition.text("Save")).click();
    }

    public void checkedNewOrder(String ownerName) {
        listOfOrders.last().shouldHave(Condition.text(ownerName));
    }

    public void clickCancel() {
        cancelButton.shouldHave(Condition.text("Cancel")).click();
    }

    public void checkedShouldNotHaveNewOrders(String ownerName) {
        listOfOrders.last().shouldNotHave(Condition.text(ownerName));
    }

    public void searchByName(String name) {
        listOfOrders.last().shouldHave(Condition.text(name)).click();
    }

    public void clickDelete() {
        deleteButton.shouldHave(Condition.text("Delete")).click();
    }

    public void updateOrder(String updatedDates) {
        ownerNameInput.sendKeys(updatedDates);
    }

    public void checkedUpdatedOrder(String updatedDates) {
        listOfOrders.last().shouldHave(Condition.text(updatedDates));
    }
}
