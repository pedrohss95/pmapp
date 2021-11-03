var ctx = document.getElementById("myPieChart");
var chartDataStr = decodeHtml(chartData);
var chartDataArray = JSON.parse(chartDataStr)

var numericData = [];
var labelData = [];

for(let i=0; i < chartDataArray.length; i++){
	numericData[i] = chartDataArray[i].value;
	labelData[i] = chartDataArray[i].label;
}

var myChart = new Chart(ctx, {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: 'Stages',
			data: numericData,
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)'
			],
			borderWidth: 1
		}]
	},
	options: {
		responsive: true,
		plugins: {
			legend: {
				position: 'top',
			},
			title: {
				display: true,
				text: 'Project Status'
			}
		}
	},
});

function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}