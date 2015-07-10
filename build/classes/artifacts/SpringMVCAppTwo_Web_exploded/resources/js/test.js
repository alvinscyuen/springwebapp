/**
 * Created by xf on 15/6/25.
 */


//pure javascript

//window.onload = init;
//
//function init() {
//  document.getElementById("btn1").onclick = changeHeading1;
//  document.getElementById("btn2").onclick = changeHeading2;
//  document.getElementById("btn3").onclick = changeParagraph;
//    document.getElementById("linkEx").onclick = promptwarning;
//}
//
//function changeHeading1() {
//  var elm = document.getElementById("heading1");  // One element
//  elm.innerHTML = document.write(isNaN("123") + "<br>");
//}
//
//function changeHeading2() {
//  var elms = document.getElementsByTagName("h2");  // Array of elements
//  for (var i = 0; i < elms.length; i++) {
//    elms[i].innerHTML = "Hello again!";
//  }
//}
//
//function changeParagraph() {
//  var elms = document.getElementsByClassName("para");  // Array of elements
//  for (var i = 0; i < elms.length; i++) {
//    elms[i].innerHTML = "Hello again and again!";
//  }
//}
//
//function promptwarning(){
//    return prompt("Warning! Proceed With Care")
//}


//$(document).ready( function() {
//  //id
//  $('#hello').html("Hello World!!!!").addClass("highlight");
//  //id
//  $('#heading1').append("(heading matched)");
//
//  //tag
//  $('p').prepend("(tag-name matched)");
//  //css class
//  //$('.highlight').append("(css class name matched)").prepend("(css class name matched)");
//
//  $('.highlight').each( function() {
//    //match css class and process explicit loop
//    $(this).append("(css class-name matched)");
//    $(this).prepend("(css class-name matched)");
//  });
//    $('.highlight').before("<p>Before</p>").after("<p>After</p>");
//
//
//  $("#hello").html("Click me! thanks");
//
//  $("#hello").click( function(){
//    $(this).html("Hello Button is clicked!");
//    return false;});
//
//  $('p').mouseover( function(){
//    $(this).addClass("highlight");
//  });
//
//  $('p').mouseout( function(){
//        $(this).removeClass("highlight");
//      });
//
//});


//using ajax to return string
//$(document).ready( function() {
//  $(':submit').click(function (event) {
//    event.preventDefault();
//
//    var submittedMessage = $(':text[name="firstName"]').val();
//    $.ajax({
//      type: 'POST',
//      url: '/testajax',
//      data: {firstName: submittedMessage}
//    })
//        .done(function (responseText) {
//          $('#message').html('Your message is: ' + responseText);
//        })
//        .fail(function (jqXHR, status, error) {
//          alert(jqXHR.responseText);
//        })
//        .always(function (){
//         $('#thankyou').html('Thank you.');
//          //$('p:first').after('<p> Thank you. </p>');
//        });
//  })
//});


$(document).ready(function () {

    //$('p').each(function () {
    //    console.log('testing console');
    //    $(this).append('<<');
    //    $(this).prepend('>>');
    //
    //});

    //$('p').append('after').prepend('before');

    ////id
    //$('#test').text("changed text");
    //$('#test :input').addClass("orange");
    ////id
    //$('#status').append("(heading matched)");

    $('#footer').addClass("green");
    $('#footer a').addClass("orange");


    //$('p').hover(
    //    function () {
    //        $('p').addClass('highlight');
    //    },
    //    function () {
    //        $('p').removeClass('highlight');
    //    });

    //$('p').animate(
    //    {
    //        'margin-left': '30px',
    //        'margin-top': '20px',
    //        'opacity': 0.5
    //    }, 2500
    //);


    $('#submitForm').click(function (event) {
        event.preventDefault();

        var person = {
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            email: $('#email').val(),
            comments: $('#comments').val()
        }

        //console.log('sending json');


        $.ajax({
            url: '/testajax',
            type: 'POST',
            dataType: 'json',
            data: person,
            headers: {Accept: 'application/json'},
            success: function (data) {
                if (data) {
                    alert('json sent')
                    $('#message').html('response success: ' + JSON.stringify(data));
                    $('#thankyou').html('thank you');
                }
            }
        })
    });


    $('#firstNameJson').click(function () {
        //$('.firstname').append('add data successful');
        $.getJSON('/testJSONpage', function (data) {
            console.log(data);
            $(".firstname").append(data[0].firstName).append (" ").append(data[0].lastName)
            alert($.parseJSON(data).email);

        });
    })


});


//
//$(':submit').click(function (event) {
//    event.preventDefault();
//
//    var person = {
//        firstName: $('#firstName').val(),
//        lastName: $('#lastName').val(),
//        email: $('#email').val(),
//        comments: $('#comments').val()
//    }
//
//    //console.log('sending json');
//
//
//    $.ajax({
//        url: '/testajaxJSONparse',
//        type: 'POST',
//        dataType: 'json',
//        data: {'firstName': 'AlvintestFirstName'},
//        headers: {Accept: 'application/json'},
//        success: function (data) {
//            if (data) {
//                alert('json sent:' + data);
//                $('#message').html('response success: ' + JSON.stringify(data));
//                $('#thankyou').html('thank you');
//
//            }
//        },
//        error: function () {
//            alert('Error loading Json');
//        }
//
//
//    });
//});


//$('').live('click', function() {
//    $.getJSON('/testajaxJsonparse', function (data) {
//
//        var html;
//        $.each(data, function(index, d){
//            html.push("firstName: ", d. )
//
//        //
//        //var person = {
//        //    firstName: $('#firstName').val()
//        //    ,lastName: $('#lastName').val(),
//        //    email: $('#email').val(),
//        //    comments: $('#comments').val
//        }
//    });
//});


//
//        $(':text[name="firstName"]').val();
//    $.ajax({
//      type: 'POST',
//      url: '/testajax',
//      data: {firstName: submittedMessage}
//    })
//        .done(function (responseText) {
//          $('#message').html('Your message is: ' + responseText);
//        })
//        .fail(function (jqXHR, status, error) {
//          alert(jqXHR.responseText);
//        })
//        .always(function (){
//         $('#thankyou').html('Thank you.');
//          //$('p:first').after('<p> Thank you. </p>');
//        });
//  })
//});












