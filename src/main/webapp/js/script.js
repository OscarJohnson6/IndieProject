// 
const init = () => {
    document.getElementById('formSelector').addEventListener('change', function() {
        // Get the value of the selected option
        let selectedValue = this.value;

        // Show the form that matches the selected option
        let forms = document.querySelectorAll('form');
        forms.forEach(function(form) {
            if (form.id === selectedValue) {
                form.classList.remove('hidden');
            } else {
                form.classList.add('hidden');
            }
        });
    });
}

// Ensure the window.onload does not override other onload events
window.addEventListener('load', init);
