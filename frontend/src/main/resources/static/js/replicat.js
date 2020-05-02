function myFunction() {
    var rows = document.getElementsByTagName("tr");
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        var td = row.getElementsByTagName("td");
        if (td !== undefined
            && td.length === 6
            && td[5] !== undefined
            && td[5].textContent === "1") {
            row.className = "table-danger";
        }
    }
}