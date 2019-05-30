package com.epam.jersey.client;

import static com.epam.jersey.config.AutoOrderRestConfig.AUTOORDER_SERVICE_PATH;
import static com.epam.jersey.config.AutoOrderRestConfig.CREATE_NEW_PATH;
import static com.epam.jersey.config.AutoOrderRestConfig.ORDER_ID_PATH;
import static com.epam.jersey.config.AutoOrderRestConfig.ORDER_ID_TEMPLATE;
import static javax.ws.rs.client.Entity.json;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.epam.endpoints.AutoOrder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class AutoOrderClient {

    ClientConfig config = new ClientConfig();

    private Client client = ClientBuilder.newClient();

    public void createNew(AutoOrder autoOrder) {
        try {
            client = ClientBuilder.newClient();
            WebTarget add = client.target(AUTOORDER_SERVICE_PATH).path(CREATE_NEW_PATH);
            Response response = add.request(APPLICATION_JSON).post(json(autoOrder));
//            System.out.println("Response Http Status: " + response.getStatus());
//            System.out.println(response.getLocation());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public void updateById(String id, AutoOrder withOrder) {
        AutoOrder autoOrder = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget autoOrderById = client
                .target(AUTOORDER_SERVICE_PATH)
                .path(ORDER_ID_PATH)
                .resolveTemplate(ORDER_ID_TEMPLATE, id);
            Response response = autoOrderById
                .request(APPLICATION_JSON)
                .put(Entity.entity(withOrder, APPLICATION_JSON));
//            System.out.println("Response Http Status: " + response.getStatus());
            autoOrder = response.readEntity(AutoOrder.class);
//            System.out.println(
//                autoOrder.getOrderId() + ", " +
//                autoOrder.getOrderDate() + ", " +
//                autoOrder.getOwnerName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public List<AutoOrder> findAll() {
        List<AutoOrder> autoOrders = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(AUTOORDER_SERVICE_PATH);
            autoOrders = target
                .request(APPLICATION_JSON)
                .get(new GenericType<List<AutoOrder>>() {
                });
//            autoOrders.stream().forEach(
//                autoOrder -> System.out.println(autoOrder.getOrderId() + ", " +
//                                                autoOrder.getOrderDate() + ", " +
//                                                autoOrder.getOwnerName()));
            return autoOrders;
        } catch (Exception e) {
            e.printStackTrace();
            return autoOrders;
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    public AutoOrder findById(String id) {
        AutoOrder autoOrder = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget autoOrderById = client.target(
                AUTOORDER_SERVICE_PATH).path(ORDER_ID_PATH).resolveTemplate(ORDER_ID_TEMPLATE, id);
            autoOrder = autoOrderById.request(APPLICATION_JSON).get(AutoOrder.class);
//            System.out.println(autoOrder.getOrderId() + ", " +
//                               autoOrder.getOrderDate() + ", " +
//                               autoOrder.getOwnerName());
        } catch (Exception e) {
            e.printStackTrace();
            return autoOrder;
        } finally {
            if (client != null) {
                client.close();
            }
            return autoOrder;
        }
    }

    public void delete(AutoOrder order) {
        try {
            config.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
            client = ClientBuilder.newClient(config);
            WebTarget deleteById = client
                .target(AUTOORDER_SERVICE_PATH)
                .path(ORDER_ID_PATH)
                .resolveTemplate(ORDER_ID_TEMPLATE, order.getOrderId());
            deleteById.request(APPLICATION_JSON)
                .build("DELETE", Entity.entity(order, APPLICATION_JSON))
                .invoke();
//            System.out.println("Response Http Status: " + response.getStatus());
//            if (response.getStatus() == 204) {
//                System.out.println("Topic deleted successfully.");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
