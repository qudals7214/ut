// // Set new default font family and font color to mimic Bootstrap's default styling
// Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
// Chart.defaults.global.defaultFontColor = '#858796';
//
//
//
// // function getData(){
// //   const data = {
// //     "name" : $(".input_name").val(),
// //     "firstCategory" : $(".input_firstCategory").val(),
// //     "secondCategory": $(".input_secondCategory").val(),
// //     "thirdCategory" : $(".input_thirdCategory").val()
// //   }
// //
// //   $.ajax({
// //     url : "/v1/getLowestPrice",
// //     //method : "POST",
// //     type : "POST",
// //     data : JSON.stringify(data),
// //     contentType: "application/json"
// //   }).done(result =>{
// //     // console.log(result);
// //     if(result===""){
// //     }
// //     else{
// //
// //
// //
// //     }
// //   }).fail(error =>{
// //     console.log(error.responseText);
// //   });
// // }
//
var arr = new Array();

var datearr = new Array();
var datetitle = new Array();

for(var i=0; i<10; i++){
  arr[i] = i;
}

for(var i=0; i<10; i++){
  datearr[i] = i+"월";
}
for(var i=0; i<10; i++){
  datetitle[i] = i+"번 제목 "+i;
}
//
//
//
//
// function number_format(number, decimals, dec_point, thousands_sep) {
//   // *     example: number_format(1234.56, 2, ',', ' ');
//   // *     return: '1 234,56'
//   number = (number + '').replace(',', '').replace(' ', '');
//   var n = !isFinite(+number) ? 0 : +number,
//     prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
//     sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
//     dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
//     s = '',
//     toFixedFix = function(n, prec) {
//       var k = Math.pow(10, prec);
//       return '' + Math.round(n * k) / k;
//     };
//   // Fix for IE parseFloat(0.55).toFixed(0) = 0;
//   s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
//   if (s[0].length > 3) {
//     s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
//   }
//   if ((s[1] || '').length < prec) {
//     s[1] = s[1] || '';
//     s[1] += new Array(prec - s[1].length + 1).join('0');
//   }
//   return s.join(dec);
// }
//
// //
// // // Area Chart Example
// // var ctx = document.getElementById("myAreaChart");
// // var myLineChart = new Chart(ctx, {
// //   type: 'line',
// //   data: {
// //     labels: ["2021년 9월", "2021년 10월", "2021년 11월", "2021년 12월", "2022년 1월", "2022년 2월", "2022년 3월", "2022년 4월", "2022년 5월", "2022년 6월", "2022년 7월", "2022년 8월"],
// //     datasets: [{
// //       label: "Earnings",
// //       lineTension: 0.3,
// //       backgroundColor: "rgba(78, 115, 223, 0.05)",
// //       borderColor: "rgba(78, 115, 223, 1)",
// //       pointRadius: 3,
// //       pointBackgroundColor: "rgba(78, 115, 223, 1)",
// //       pointBorderColor: "rgba(78, 115, 223, 1)",
// //       pointHoverRadius: 3,
// //       pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
// //       pointHoverBorderColor: "rgba(78, 115, 223, 1)",
// //       pointHitRadius: 10,
// //       pointBorderWidth: 2,
// //       data: [253000, 240000, 240000, 273000, 195000, 249000, 229000, 277000, 229000, 288000, 244000, 277000],
// //     }],
// //   },
// //   options: {
// //     maintainAspectRatio: false,
// //     layout: {
// //       padding: {
// //         left: 10,
// //         right: 25,
// //         top: 25,
// //         bottom: 0
// //       }
// //     },
// //     scales: {
// //       xAxes: [{
// //         time: {
// //           unit: 'date'
// //         },
// //         gridLines: {
// //           display: false,
// //           drawBorder: false
// //         },
// //         ticks: {
// //           maxTicksLimit: 7
// //         }
// //       }],
// //       yAxes: [{
// //         ticks: {
// //           maxTicksLimit: 5,
// //           padding: 10,
// //           // Include a dollar sign in the ticks
// //           callback: function(value, index, values) {
// //             return number_format(value)+ '￦';
// //           }
// //         },
// //         gridLines: {
// //           color: "rgb(234, 236, 244)",
// //           zeroLineColor: "rgb(234, 236, 244)",
// //           drawBorder: false,
// //           borderDash: [2],
// //           zeroLineBorderDash: [2]
// //         }
// //       }],
// //     },
// //     legend: {
// //       display: false
// //     },
// //     tooltips: {
// //       backgroundColor: "rgb(255,255,255)",
// //       bodyFontColor: "#858796",
// //       titleMarginBottom: 10,
// //       titleFontColor: '#6e707e',
// //       titleFontSize: 14,
// //       borderColor: '#dddfeb',
// //       borderWidth: 1,
// //       xPadding: 15,
// //       yPadding: 15,
// //       displayColors: false,
// //       intersect: false,
// //       mode: 'index',
// //       caretPadding: 10,
// //       callbacks: {
// //         label: function(tooltipItem, chart) {
// //           var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
// //           return datasetLabel + ': ' + number_format(tooltipItem.yLabel)+ '￦';
// //         }
// //       }
// //     }
// //   }
// // });
//
// let dataList={
//   item : "name",
//   resultDate : "2022-02-02",
//   price: 1
// };
// // String item;
// // int price;
// //
// // Date resultDate;
// // dataList.push(sessionStorage.getItem("result"));
// // dataList =
// dataList = JSON.stringify("result");
//
//
// let dateList = new Array();
// let itemList = new Array();
// let priceList = new Array();
//
// dataList.forEach(e =>{
//   dateList.push(e.resultDate);
//   itemList.push(e.item);
//   priceList.push(e.price);
// })
//
//
// // Area Chart Example
// var ctx = document.getElementById("myAreaChart");
// var myLineChart = new Chart(ctx, {
//   type: 'line',
//   data: {
//     labels: datearr,//가로값 날짜
//     datasets: [{
//       label: "Price", //가격 라벨
//       lineTension: 0.3,
//       backgroundColor: "rgba(78, 115, 223, 0.05)",
//       borderColor: "rgba(78, 115, 223, 1)",
//       pointRadius: 3,
//       pointBackgroundColor: "rgba(78, 115, 223, 1)",
//       pointBorderColor: "rgba(78, 115, 223, 1)",
//       pointHoverRadius: 3,
//       pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
//       pointHoverBorderColor: "rgba(78, 115, 223, 1)",
//       pointHitRadius: 10,
//       pointBorderWidth: 2,
//       data: arr,      //세로값 가격
//     }],
//   },
//   options: {
//     maintainAspectRatio: false,
//     layout: {
//       padding: {
//         left: 10,
//         right: 25,
//         top: 25,
//         bottom: 0
//       }
//     },
//     scales: {
//       xAxes: [{
//         time: {
//           unit: 'date'
//         },
//         gridLines: {
//           display: false,
//           drawBorder: false
//         },
//         ticks: {
//           maxTicksLimit: 7
//         }
//       }],
//       yAxes: [{
//         ticks: {
//           maxTicksLimit: 5,
//           padding: 10,
//           // Include a dollar sign in the ticks
//           callback: function(value, index, values) {
//             return number_format(value)+ '￦';
//           }
//         },
//         gridLines: {
//           color: "rgb(234, 236, 244)",
//           zeroLineColor: "rgb(234, 236, 244)",
//           drawBorder: false,
//           borderDash: [2],
//           zeroLineBorderDash: [2]
//         }
//       }],
//     },
//     legend: {
//       display: false
//     },
//     tooltips: {
//       backgroundColor: "rgb(255,255,255)",
//       bodyFontColor: "#858796",
//       titleMarginBottom: 10,
//       titleFontColor: '#6e707e',
//       titleFontSize: 14,
//       borderColor: '#dddfeb',
//       borderWidth: 1,
//       xPadding: 15,
//       yPadding: 15,
//       displayColors: false,
//       intersect: false,
//       mode: 'index',
//       caretPadding: 10,
//       callbacks: {
//         label: function(tooltipItem, chart) {
//           var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
//           // return datetitle[number_format(tooltipItem.yLabel)] +"\n" + datasetLabel + ': ' + number_format(tooltipItem.yLabel)+ '￦';
//           return itemList[tooltipItem.datasetIndex] +"\n" + datasetLabel + ': ' + number_format(tooltipItem.yLabel)+ '￦';
//         }
//       }
//     }
//   }
// });
//




// dataList = JSON.parse("result");
//
//




let dateList = document.getElementsByName("date").values();
let itemList = document.getElementsByName("item").values();
let priceList = document.getElementsByName("price").values();

let dateList2= new Array();
let itemList2= new Array();
let priceList2= new Array();


console.log(priceList2);
console.log(priceList);

alert(priceList);
alert(typeof priceList);
// alert(priceList.size);
// alert(priceList.size());
// alert(priceList.values);
// alert(priceList2);

// priceList.forEach(e =>{
//   alert(e);
// })

// let a = [4, 5, 6];
//
// for (let v of a) console.log(v); // 4 5 6 이 차례대로 console에 찍힘

// for (let v of priceList) priceList2.push(v);
// alert(priceList2);
// alert(priceList2.length);





dateList.forEach(e=>{
  dateList2.push(e)
})

itemList.forEach(e=>{
  itemList2.push(e)
})

priceList.forEach(e=>{
  priceList2.push(e)
})

//
// for(let i =0; i<dateList.length; i++){
//   dateList2.push(JSON.parse(dateList.keys(i)));
//   itemList2.push(JSON.parse(itemList.keys(i)));
//   priceList2.push(JSON.parse(priceList.keys(i)));
//
// }


dateList.forEach(e =>{

})

//
// // dataList.forEach(e =>{
// //   dateList.push(dataList);
// //   itemList.push(e.item);
// //   priceList.push(e.price);
// // })




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

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: dateList2,            // 가로값
    datasets: [{
      label: itemList2,    // 제목
      lineTension: 0.3,
      backgroundColor: "rgba(78, 115, 223, 0.05)",
      borderColor: "rgba(78, 115, 223, 1)",
      pointRadius: 3,
      pointBackgroundColor: "rgba(78, 115, 223, 1)",
      pointBorderColor: "rgba(78, 115, 223, 1)",
      pointHoverRadius: 3,
      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
      pointHitRadius: 10,
      pointBorderWidth: 2,
      data: priceList2,   // 세로값 y축
    }],
  },
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
          // return datearr[tooltipItem.datasetIndex] +"\n" + datasetLabel + ': ' + number_format(tooltipItem.yLabel)+ '￦';
        }
      }
    }
  }
});
