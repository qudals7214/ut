// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function number_format(number, decimals, dec_point, thousands_sep) {
    // *     example: number_format(1234.56, 2, ',', ' ');
    // *     return: '1 234,56'
    number = (number + '').replace(',', '').replace(' ', '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function(n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.round(n * k) / k;
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}


// let search1;

let dateList2;
let itemList2;
let priceList2;
let searchKeyword;

function searchResult() {
    dateList2 = new Array();
    itemList2 = new Array();
    priceList2 = new Array();
    searchKeyword = "";

    let getSearch = $("[name=search]").val();
    searchKeyword=getSearch;
    console.log(getSearch);
    // alert(getSearch);
    dateList2 = new Array();
    itemList2 = new Array();
    priceList2 = new Array();
    // let result;
    // result.

    // search1=search;
    // console.log("ee");
    //
    // let search = $("[name=searchKeyword]").val();
    // console.log(search);
    $.ajax({
        type: "GET",
        url: "/v1/search",
        data : {
            "search" : getSearch
        },
        contentType : 'application/json; charset=UTF-8',
        dataType : 'json',
        success : function (result){
            searchKeyword=getSearch;
            result.sort((a, b) => new Date(a['resultDate']) - new Date(b['resultDate']))
            result.forEach(e => {
                // alert(e);
                dateList2.push(e['resultDate']);
                itemList2.push(e['item']);
                priceList2.push(e['price']);
                console.log(e);
            })

            // window.onload = function () {
            //     console.log(search);
            //         console.log(dateList2[0].val());
            //
            //     }
        // location.href="/index";
        }
    })
    sessionStorage.setItem("search",getSearch)
    // location.href="/result";

    // // alert(search);
    // console.log("데이트리스트2");
    // console.log(dateList2);
    // console.log("아이템리스트2");
    // console.log(itemList2);
    // console.log("프라이스리스트2");
    // console.log(priceList2);

    // alert("데이트리스트"+dateList2);
    // alert("아이템리스트"+itemList2);
    // alert("프라이스리스트"+priceList2);
}


// window.onload = function(){
//     console.log("ㄷㄷ")
//
//     let search = sessionStorage.getItem("search");
//     if(search!="null"){
//
//     console.log();
//     // console.log(dateList2[0]);
//     console.log(search)
//
//     // $.ajax({
//     //     type: "GET",
//     //     url: "/v1/search",
//     //     data : ""+search,
//     //     contentType : 'application/json; charset=UTF-8',
//     //     dataType : 'json',
//     //     success : function (result){
//     //         result.forEach(e => {
//     //             // dateList2.push(e.getDate());
//     //             // itemList2.push(e.getItem());
//     //             // priceList2.push(e.getPrice());
//     //             console.log(e);
//     //         })
//     //
//     //     }
//     // })
//
//     }
// }


// dateList2 = [2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022,2020,2021,2022]
// priceList2 = [1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000,1000,10000,5000]
// itemList2 = []


// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: dateList2,
        // labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
            // label: itemList2,
            label: "Earnings",
            // lineTension: 0.3,
            // backgroundColor: "rgba(78, 115, 223, 0.05)",
            // borderColor: "rgba(78, 115, 223, 1)",
            // pointRadius: 3,
            // pointBackgroundColor: "rgba(78, 115, 223, 1)",
            // pointBorderColor: "rgba(78, 115, 223, 1)",
            // pointHoverRadius: 3,
            // pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            // pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            // pointHitRadius: 10,
            // pointBorderWidth: 2,
            data: priceList2,
            // data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
        }],
    },


    // data:{
    //   labels: dateList2,
    //     // datasets:[{
    //     //     label : itemList2,
    //     //     data : priceList2
    //     // }]
    // },
    options: {
        maintainAspectRatio: false,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                time: {
                    unit: 'date'
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 7
                }
            }],
            yAxes: [{
                ticks: {
                    maxTicksLimit: 5,
                    padding: 10,
                    // Include a dollar sign in the ticks
                    callback: function(value, index, values) {
                        return '$' + number_format(value);
                    }
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }],
        },
        legend: {
            display: false
        },
        tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            intersect: false,
            mode: 'index',
            caretPadding: 10,
            callbacks: {
                label: function(tooltipItem, chart) {
                    var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                    return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
                }
            }
        }
    }
});
