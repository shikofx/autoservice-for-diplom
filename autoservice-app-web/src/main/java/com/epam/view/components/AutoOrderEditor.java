package com.epam.view.components;

import com.epam.endpoints.AutoOrder;
import com.epam.jersey.client.AutoOrderClient;
import com.epam.jersey.config.AutoOrderRestConfig;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@SpringComponent
@UIScope
public class AutoOrderEditor extends VerticalLayout implements KeyNotifier {

    private final AutoOrderClient autoOrderClient;
    private AutoOrder autoOrder = new AutoOrder();
    private String currentDateString = AutoOrderRestConfig.SIMPLE_DATE_FORMAT.format(new Date());
    private TextField orderId = new TextField("", "");
    private TextField orderDate = new TextField("", currentDateString);
    private TextField ownerName = new TextField("", "");
    private HorizontalLayout orderFieldsToolbar = new HorizontalLayout(orderId, orderDate, ownerName);
    private Button saveBttn = new Button("Save", VaadinIcon.GAVEL.create());
    private Button cancelBttn = new Button("Cancel", VaadinIcon.ESC.create());
    private Button deleteBttn = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actionsToolbar = new HorizontalLayout();

    Binder<AutoOrder> binder = new Binder<>(AutoOrder.class);

    private ChangeHandler changeHandler;
    public interface ChangeHandler {
        void onChange();
    }
    public void setChangeHandler(ChangeHandler changeHandler) {
        this.changeHandler = changeHandler;
    }

    @Autowired
    public AutoOrderEditor(AutoOrderClient autoOrderClient) {
        orderId.setEnabled(false);
        orderDate.setEnabled(false);
        ownerName.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        this.autoOrderClient = autoOrderClient;
        actionsToolbar.add(cancelBttn, saveBttn, deleteBttn);
        binder.bindInstanceFields(this);
        add(orderFieldsToolbar, actionsToolbar);

        setSpacing(true);

        saveBttn.getElement().getThemeList().add("primary");
        deleteBttn.getElement().getThemeList().add("primary");
        cancelBttn.getElement().getThemeList().add("secondary");

        addKeyPressListener(Key.ENTER, e -> save());
        saveBttn.addClickListener(e -> save());
        deleteBttn.addClickListener(e -> deleteOrder());
        cancelBttn.addClickListener(e -> editOrder(autoOrder));
        setVisible(false);
    }

    private void deleteOrder() {
        autoOrderClient.delete(autoOrder);
        changeHandler.onChange();
    }

    private void save() {
        if (autoOrder.getOrderId().isEmpty()) {
            autoOrderClient.createNew(autoOrder);
        } else {
            autoOrderClient.updateById(autoOrder.getOrderId(), autoOrder);
        }
        changeHandler.onChange();
    }

    public void editOrder(AutoOrder newOrder) {
        if (newOrder == null) {
            setVisible(false);
            return;
        }
        if (!newOrder.getOrderId().isEmpty()) {
            newOrder = autoOrderClient.findById(newOrder.getOrderId());
        } else {
            currentDateString = AutoOrderRestConfig.SIMPLE_DATE_FORMAT.format(new Date());
            this.autoOrder = newOrder
                .withOrderDate(currentDateString)
                .withOwnerName("");
        }
        binder.setBean(autoOrder);
        orderId.setValue(newOrder.getOrderId());
        orderDate.setValue(newOrder.getOrderDate());
        ownerName.setValue(newOrder.getOwnerName());
        setVisible(true);
        orderDate.focus();
    }
}
