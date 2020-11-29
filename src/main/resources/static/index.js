$(document).ready(function(){
	$.ajax('/csv', { success: function() {
		$.ajax('/data/2018', { success: function(data) {
			var content = '<table>';
			for ( i = 0; i < data.length; ++i ) {
				content += '<tr>'
				content += '<td>' + data[i].state + '</td>';
				content += '<td>' + data[i].year + '</td>';
				content += '<td>' + data[i].population + '</td>';
				content += '</tr>'
			}
			content += '</table>'
			$('#data').append(content);
		}});
		$.ajax('/analysis/2018', { success: function(data) {
			var content = '<p>min = ' + data.min + ' max = ' + data.max + ' mean = ' + data.mean + ' sd = ' + data.standardDeviation + '</p>';
			$('#analysis').append(content);
		}});
	}});
})