/**
 * Created by xf on 15/7/1.
 */


$(document).ready(function () {


    //display sub total for each item
    var returnSubtotalPrice = function (subTotal, i) {

            //Grab all the subtotal price
            var itemSubtotalPrices = $('.item-subtotal');

            // Identify the current subtotal using i as the index, current sub total in index 'i' field
            var currentSubtotal = $(itemSubtotalPrices[i]);
            //
            // Modify the current subtotal field
            currentSubtotal.text('$' + (subTotal).toFixed(2));

    };


    //display total price
    var returnTotalPrice = function (totalPrice) {
        $('#total-price').text('$' + totalPrice.toFixed(2));

    };


    //ajax function sent to controller to calculate subtotal of 'items' object
    var sendAjax = function () {
        var itemPrices = $('.item-price'); // Select all the prices
        var itemQuantities = $('.quantity'); // Select all the quantities
        var itemLength = itemPrices.length; // Both arrays will have the same length
        var totalPrice = 0; // Accumulator

        for (var i = 0; i < itemLength; i++) {

            var price = $(itemPrices[i]).text().replace('$', '');
            var quantity = $(itemQuantities[i]).val();

            var item = {
                "itemPrice": parseFloat(price),
                "itemQuantity": parseInt(quantity)// "10.00"
            }

            $.ajax( {
                async: false,
                url: '/subtotal.json',
                type: 'POST',
                //dataType: 'text',
                data: JSON.stringify(item),
                headers: {'Content-Type': 'application/json'},
                success: function (subTotal) {
                    //console.log(subTotal);
                    returnSubtotalPrice(subTotal, i);

                    totalPrice = totalPrice + subTotal;
                    returnTotalPrice(totalPrice);
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert(textStatus + ":" + errorThrown);
                }
            }) //end of ajax
        }//end of for loop
    } // end of function


//create item
    var createItem = function () {
        // must check price is integer
        var itemName = $('#new-item-name').val();
        var itemUnitPrice = $('#new-item-unit-price').val();

        if ($.isNumeric(itemUnitPrice) == false) {
            alert('Unit price must be a number');
        } else if (itemName == '') {
            alert('Item name cannot be empty');
        } else {
            itemUnitPrice = Number(itemUnitPrice).toFixed(2)
            var newItem = '<div class="item row"> <div class="item-name col-xs-4">' + itemName + '</div> <div class="item-price col-xs-3">' + '$' + itemUnitPrice + '</div> <div class="item-qty col-xs-3"> <label>QTY</label> <input class="quantity" value="0"> <button class="cancel">Cancel</button> </div> <div class="item-subtotal col-xs-2"> $0.00 </div> </div>';
            //$('#items-list').prepend(newItem);
            $(newItem).prependTo($('#items-list')).slideDown('slow');
        }
    };


//click calculate prices button
    $('#calc-prices-button').click(function () {
        //returnTotalPrice();
        sendAjax();
    });


//on keying quantity input
    $(document).on('keyup', '.quantity', function () {

            if($(this).val().length === 0) {
                alert('item must not be of length: ' + $(this).val().length);
            }
        else {
                sendAjax();
            }
    });


//on creating item
    $('#new-item-create').click(function () {
        createItem();
    });


//on clicking cancel button
    $(document).on('click', '.cancel', function () {
        // fadeOut = hiding = display: none;
        $(this).parent().parent().fadeOut('slow', function () {
            $(this).remove(); // This is removing the HTML
            // $(this).html(''); // This is removing the HTML
            returnTotalPrice(); // Recalculate the total price
        });
    });


}); //end of on document load


