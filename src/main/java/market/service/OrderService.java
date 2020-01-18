package market.service;

import market.domain.Order;
import market.domain.UserAccount;
import market.exception.EmptyCartException;
import market.exception.OrderNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * Сервис заказа.
 */
public interface OrderService {

	void save(Order order);

	void delete(Order order);

	Order findOne(long orderId);

	List<Order> findAll();

	Page<Order> findAll(PageRequest request);

	List<Order> findByUserAccount(UserAccount userAccount);

	Page<Order> findByExecuted(boolean stored, Pageable pageable);

	Page<Order> findByExecutedAndDateCreatedGreaterThan(boolean executed, Date created, Pageable pageable);

	Page<Order> findByDateCreatedGreaterThan(Date created, Pageable pageable);

	Page<Order> fetchFilteredAndPaged(String executed, String created, PageRequest request);

	//---------------------------------------- Операции с заказами пользователя

	/**
	 * Оформление нового заказа.
	 *
	 * @param userLogin    логин покупателя
	 * @param deliveryCost цена доставки
	 * @param cardNumber
	 * @return вновь созданный заказ
	 * @throws EmptyCartException если оплачивается пустая корзина
	 */
	Order createUserOrder(String userLogin, int deliveryCost, String cardNumber) throws EmptyCartException;

	/**
	 * Получение всех заказов покупателя.
	 *
	 * @param userLogin логин покупателя
	 * @return список заказов
	 */
	List<Order> getUserOrders(String userLogin);

	/**
	 * Получение одного заказа покупателя.
	 *
	 * @param userLogin логин покупателя
	 * @param id        идентификатор заказа
	 * @return заказ с запрошенным id
	 * @throws OrderNotFoundException если у пользователя не существует запрошенного заказа
	 */
	Order getUserOrder(String userLogin, long id) throws OrderNotFoundException;
}
