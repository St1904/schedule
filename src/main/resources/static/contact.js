/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */
$(document).ready(function() {
    $.ajax({
        type: "GET",
        datatype: "json",
        url: "/rest/contact",
        success: function (data) {
            $.each(data, function (i, val) {
                // alert(val.id + " " + val.value);
                var newLi = document.createElement("li");
                newLi.innerHTML = val.id + " " + val.value + " " + val.contactName.id + " " + val.contactName.name;
                list.appendChild(newLi);
            })
        }
    /*}).then(function(data) {
        $('.contact-id').append(data.id);
        $('.contact-name').append(data.name);*/
    });
});