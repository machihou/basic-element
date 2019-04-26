function getColumnDetail(column) {
    swal($(column).attr("Course"), $(column).attr("Teacher"))
}

function CreateTable(tdData) {
    for (var type = 1; type <= 3; type++) {
        var addNum = null;
        var col = null;
        switch (type) {
            case 1:
                addNum = 0;
                col = 4;
                break;
            case 2:
                addNum = 4;
                col = 4;
                break;
            case 3:
                addNum = 8;
                col = 2;
                break
        }
        var _table = document.querySelector("#table" + type);
        $(_table).html("");
        _table.setAttribute("class", "am-table");
        var _row;
        var _cell;
        var _thead;
        var _tbody;
        var _span;
        var Section = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十"];
        var Statue = false;
        _thead = document.createElement("thead");
        _row = document.createElement("tr");
        for (var j = 0; j < col + 1; j++) {
            _cell = document.createElement("th");
            if (j == 0) {
                _cell.innerText = "教室名称";
                _cell.style.width = "30%"
            } else {
                _cell.innerText = Section[addNum + j - 1]
            }
            _row.appendChild(_cell);
            _thead.appendChild(_row);
            _table.appendChild(_thead)
        }
        _tbody = document.createElement("tbody");
        for (var i in tdData) {
            console.log(i)
            var roomName = tdData[i].roomName;
            var jsonValue = JSON.parse(tdData[i].jsonValue);
            var status = false;
            _row = document.createElement("tr");
            _tbody.appendChild(_row);
            _table.appendChild(_tbody);
            for (var j = 0; j < col + 1; j++) {
                _cell = document.createElement("td");
                if (j == 0) {
                    _cell.innerText = roomName
                } else {
                    if (jsonValue == null) {
                        status = false
                    } else {
                        status = jsonValue.hasOwnProperty(j)
                    }
                    _span = document.createElement("span");
                    if (status) {
                        _span.innerText = "占"
                    } else {
                        _span.innerText = "空"
                    }
                    if (status) {
                        _span.setAttribute("class", "zhan");
                        var x = jsonValue[j];
                        for (var i in x) {
                            _span.setAttribute("Course", i);
                            _span.setAttribute("Teacher", x[i])
                        }
                        _span.onclick = function () {
                            getColumnDetail(this)
                        }
                    } else {
                        if (status) {
                            _span.setAttribute("class", "kong")
                        }
                    }
                    _cell.appendChild(_span)
                }
                _row.appendChild(_cell)
            }
        }
    }
};




