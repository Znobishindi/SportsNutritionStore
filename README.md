### Магазин спортивного питания
Данная программа реализует некий интерактив между посетителем магазина и продавцом.

Перечень товаров разделен на группы, описание которых можно вывести в консоль. Изначально добавлен ряд товаров, имеющих свои уникальные признаки.

Покупателю предлагается выбрать товар из предложенных и добавить их в корзину. Если товара нет в наличии, продавец предложит их заказать.

У покупателя есть кошелек, количество денег в котором задается изначально.

При выборе опции "Показать корзину" в консоль будет выведен перечень товаров, которые пользователь до этого в нее положил. Так же будет указана общая стоимость товаров в корзине. Если покупатель еще не добавлял товары, то программа ему об этом сообщит.
У покупателя есть возможность удалить любой товар из корзины.

Когда переходим к оформлению покупки, программа проверит, есть ли у покупателя дисконтная карта и, в случае ее отсутствия, предложит ее завести (хотим заводим, хотим нет).
Условия использования дисконтной карты программа сообщает покупателю.

Во время совершения покупки программа не только проверит достаточность средств у покупателя для совершения покупки (если их недостаточно, предложит удалить часть товаров из корзины, но купить не даст), но и предложит либо списать имеющиеся баллы на дисконтной карте, либо их накопить.

После завершения покупки продавец выпишет товарный чек, в котором указаны детали сделки.

Программа на данном этапе еще "сырая". Планирую реализовать функционал доставки, расширить товарный чек с выгрузкой его в файл, добавить выбор условий дисконта, парописать Unit-тесты ... В общем, куда заведет фантазия)))
