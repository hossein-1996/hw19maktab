$(document).ready(function () {
    var url = "http://localhost:8083/employee_servlet_war_exploded/view";
    var headers = [
        "FIRST NAME",
        "LAST NAME" ,
        "EMAIL"
    ];

    $("button").click(function () {
        $.get(url,function (data,status) {
            console.log(status);
            $("table").append("<tr>");
            for (var i=0; i<headers.length; i++ ){
                $("table").append(
                    "<th>"+ headers[i] +"</th>>"
                );
            }
            $("table").append("</tr>");
            data.forEach((std)=>{
                $("table").append(
                    "<tr>"+
                    "<td>"+ std.firstname +"</td>" +
                    "<td>"+ std.lastname +"</td>" +
                    "<td>"+ std.email +"</td>" +
                    "</tr>"
                )
            });
        });
    })

    $("form").submit(function (event) {
        event.preventDefault();
        var firstName = event.target.firstname.value;
        var lastName = event.target.lastname.value;
        var phoneNumber = event.target.phonenumber.value;
        var age = event.target.age.value;
        $.post(url,{firstname:firstName , lastname:lastName , phonenumber:phoneNumber , age:age })
    })

})


