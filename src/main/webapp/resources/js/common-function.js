$(document).ready(function(){

	// Add comma thousand function
	$.fn.digits = function() {
		return this.each(function() {
					$(this).text($(this).text().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1 "));
				})
	};

	// Add comma thousand function
	Handlebars.registerHelper('formatCurrency', function(value) {
		return value.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
	});

	// Add comma thousand function
	Handlebars.registerHelper('get_length', function(map) {
		return Object.keys(map).length;
	});

	// Custom if condition in handle bar. Use this with syntas {{#ifCond var1 '==' var2}} .... {{else}}.... {{/#ifCond}}
	Handlebars.registerHelper('ifCond',
			function(v1, operator, v2, options) {

				switch (operator) {
				case '==':
					return (v1 == v2) ? options.fn(this) : options
							.inverse(this);
				case '!=':
					return (v1 != v2) ? options.fn(this) : options
							.inverse(this);
				case '<':
					return (v1 < v2) ? options.fn(this) : options
							.inverse(this);
				case '<=':
					return (v1 <= v2) ? options.fn(this) : options
							.inverse(this);
				case '>':
					return (v1 > v2) ? options.fn(this) : options
							.inverse(this);
				case '>=':
					return (v1 >= v2) ? options.fn(this) : options
							.inverse(this);
				case '&&':
					return (v1 && v2) ? options.fn(this) : options
							.inverse(this);
				case '||':
					return (v1 || v2) ? options.fn(this) : options
							.inverse(this);
				default:
					return options.inverse(this);
				}
			});

	// Start @index by 1
	Handlebars.registerHelper("inc", function(value, options) {
		return parseInt(value) + 1;
	});
});