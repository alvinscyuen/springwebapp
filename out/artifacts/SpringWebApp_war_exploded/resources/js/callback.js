/**
 * Created by xf on 15/7/3.
 */


//testing callback function

function testAjax(successCallBack) {

        var person = {
            'firstName': 'Alvin',
            'lastName': 'Yuen',
            'email': 'ayuen@ayuen.com',
            'comments': 'new comments inserted'
        };

        $.ajax({

            url: '/testJsonObj.json',
            headers: {'Content-Type': 'application/json'},
            method:'post',
            data: JSON.stringify(person),
            dataType: 'json',
            success: function (response) {
                successCallBack(response);
            }
        });
}


$(function(){

    $('#callBackButton').click(function(){

        testAjax(function(output){
            $('#callBackContent').text(JSON.stringify(output));
        });

    });
});






