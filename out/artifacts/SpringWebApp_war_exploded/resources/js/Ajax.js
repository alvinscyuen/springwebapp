/**
 * Created by xf on 15/6/30.
 */


//$(document).ready(function () {

$(function () {
    var name = ['tom', 'john', 'mary'];
    var cheese = {
        item: 'cheddar cheese',
        price: 75,
        lowCarb: false
    }
    console.log(cheese);
    cheese.quantity = 3;
    console.log(cheese);
    delete cheese.quantity;
    console.log('is this an array?' + Array.isArray(name) + 'length: ' + name.length);

    name.forEach(function (element, index) {
        console.log(element + " = " + index);
    })

    name.push('peter');
    name.push('alfred');
    console.log("after push" + name);

    var extra = name.shift();
    console.log("shift function..removed name" + extra);
})

$(function initializeGrades(num) {
    var num_students = 10;
    var class_grades = [];

    for (var i = 0; i <= num_students; i++) {
        class_grades.push(Math.round(Math.random() * (100 + 1)));
    }
    class_grades.forEach(function (element) {
        console.log(element);
    })

    class_grades = removeMinMax(class_grades);
    console.log("After removal" + class_grades);

})

function removeMinMax(grades) {

    var min = 100, max = 0;
    var minPos, maxPos = null;

    for (var i = 0; i < grades.length - 1; i++) {
        if (grades[i] < min) {
            min = grades[i];
            minPos = i;
        }
        if (grades[i] > max) {
            max = grades[i];
            maxPos = i;
        }
    }
    console.log("min element: " + grades[minPos] + "Position" + minPos);
    console.log("max element: " + grades[maxPos] + "Position" + maxPos);

    grades.splice(minPos, 1);
    grades.splice(maxPos, 1);

    return grades;
}



//pass single JSON Obj
$(function () {

    $('#submitFormTwo').click(function (event) {
        event.preventDefault();

        //retrieve and store form variables in person obj
        var person = {
            "firstName": $('#firstName').val(),
            "lastName": $('#lastName').val(),
            "email": $('#email').val(),
            "comments": $('#comments').val()
        };

        //initialize person object
        //var person = new Object();
        //person.firstName = $('#firstName').val();
        //person.lastName = $('#lastName').val();
        //person.email = $('#email').val();
        //person.comments = $('#comments').val();


        //ajax - stringify object
        $.ajax({
            url: '/testJsonObj.json',
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(person),
            //headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
            success: function (data) {
                if (data) {
                    alert('json sent');
                    //alert(data["firstName"]);
                    $('#message').append(JSON.stringify(data));

                    $('#thankyou').append('Json sent');

                    console.log(data);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                alert(textStatus + ":" + errorThrown);
            }
        })
    });
})


//pass JSON array
$(function () {

    $('#submitForm').click(function (event) {
        event.preventDefault();

        //handle JSON from GET Request
        $.getJSON('/retrieveJSON', function (JsonData) {


            alert("Passing Stringified Data: " + JSON.stringify(JsonData));

            $.ajax({
                url: '/testJSONArray.json',
                method: 'POST',
                dataType: 'json',
                //contentType: 'application/json',
                data: JSON.stringify(JsonData),
                headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
                success: function (data) {
                    if (data) {
                        alert('json sent')
                        $('#returnObj').append(JSON.stringify(data));

                        //output first name and last name in html
                        var output = "<ul>";
                        data.forEach(function (object) {
                            output += "<li> First Name & Last Name: " + object.firstName + " " + object.lastName + "</li>";
                        })
                        output += "</ul>";

                        $('#response').html(output);
                    }
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert(textStatus + ":" + errorThrown);
                }
            })
            //})
        });
    });
})


//parse Json obj 'firstName'  using $.getJSON to retrieve JSON
$(function () {
    $('#firstNameJson').click(function () {
        //$('.firstname').append('add data successful');
        $.getJSON('/retrieveJSON', function (data) {
            //data = object
            console.log(data);
            data.forEach(function (object) {
                $("#showFirstNameJson").append(object.firstName + " ");
            })
        });
    })
})


$(function () {
    $('#lastNameJson').click(function () {
        $.getJSON('/retrieveJSON', function (data) {
            console.log(data);
            data.forEach(function (object) {
                $("#showLastNameJson").append(object.lastName + " ");
            })
        });
    })
})


$(function () {
    $('#emailJson').click(function () {
        $.getJSON('/retrieveJSON', function (data) {
            console.log(data);
            data.forEach(function (object) {
                $("#showEmailJson").append(object.email + " ");
            })
        });
    })
})


$(function () {
    $('#commentsJson').click(function () {
        $.getJSON('/retrieveJSON', function (data) {
            console.log(data);
            data.forEach(function (object) {
                $("#showCommentsJson").append(object.comments + " ");
            })
        });
    })
})


//parse Json String to Json value/Obj
$(function () {
    $('#ParseString').click(function () {
        alert("::parse string processing::");

        var string = '[{"firstName":"Alvin","lastName":"Yuen"}, {"firstName":"Stan","lastName":"Yuan"}, {"firstName":"Can", "lastName":"Lee"}]';

        var array = JSON.parse(string);

        array.forEach(function (object) {
            $('#showParseString').append(object.firstName + " " + object.lastName + " ");
        })
    })
})


//pass json into controller and return String
$(function () {

    $('#htmlButton').click(function (event) {

        var json = {
            "id": 123
        };

        $.ajax({

            url: '/addsomehtml',
            data: JSON.stringify(json),
            //data: JSON.stringify({"id": "123"}),  //query string
            type: 'POST',
            headers: {'Content-Type': 'application/json'},
            success: function (json) {
                console.log("response: " + json);
                $("<h1>").text(json).appendTo("body");
                //$("<div class=\"content\">").html(json.html).appendTo("body");
            },
            error: function (xhr, status, errorThrown) {
                alert("Sorry, there was a problem!");
                console.log("Error: " + errorThrown);
                console.log("status: " + status);
                console.dir(xhr);
            },
            complete: function (xhr, status) {
                alert("the request is complete");
            }

        }) // end of ajax function
    })  //end of click function


    //OMDB API
    $(function () {
        $.ajax({
            type: 'GET',
            url: 'http://www.omdbapi.com/?t=matrix&y=&plot=short&r=json',
            dataType: 'JSON',
            success: function (response) {
                console.log("omd: " + JSON.stringify(response));
            }
        });
    })


    //trigger ajax search for title, year, poster of OMDB API
    function search(title) {

        $.ajax({
            type: 'GET',
            url: 'http://www.omdbapi.com/?t=' + title,
            dataType: 'JSON',
            success: function (response) {
                console.log("Finish searching for " + title);
                console.log("This is the response " + response);

                $('#movietitle').text(response['Title']);
                $('#movieyear').text(response['Year']);
                $('#movieposter').attr("src", response['Poster']);
            }
        })
    }


    $(function movieSearch() {
        $('#search-form').submit(function (event) {
            event.preventDefault()

            var title = $('#searchtitle').val();
            search(title);
        })
    })


    $(function () {
        $.ajax({})


    })


    // good practice ---- beware anonymous functions
    var PI = {


        onReady: function () {


        },

        anotherFunction: function () {

        },

        thirdFunction: function () {
        }


    };


})


//})