// This file contains custom JavaScript for the application.

// Function to handle budget form submission
function submitBudgetForm(event) {
    event.preventDefault();
    const budgetData = {
        costCenter: document.getElementById('costCenter').value,
        coa: document.getElementById('coa').value,
        year: document.getElementById('year').value,
        month: document.getElementById('month').value,
        amount: parseFloat(document.getElementById('amount').value)
    };

    fetch('/api/budget', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(budgetData)
    })
    .then(response => {
        if (response.ok) {
            alert('Budget submitted successfully!');
            // Optionally, reset the form or update the UI
            document.getElementById('budgetForm').reset();
        } else {
            alert('Error submitting budget. Please try again.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred. Please try again.');
    });
}

// Function to load variance report
function loadVarianceReport() {
    fetch('/api/report/variance')
    .then(response => response.json())
    .then(data => {
        const reportTable = document.getElementById('varianceReportTable');
        reportTable.innerHTML = ''; // Clear existing table data

        data.forEach(row => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${row.coaCode}</td>
                <td>${row.coaName}</td>
                <td>${row.budget}</td>
                <td>${row.actual}</td>
                <td>${row.variance}</td>
                <td>${row.variancePercentage}</td>
            `;
            reportTable.appendChild(tr);
        });
    })
    .catch(error => {
        console.error('Error loading variance report:', error);
    });
}

// Event listeners
document.getElementById('budgetForm').addEventListener('submit', submitBudgetForm);
document.addEventListener('DOMContentLoaded', loadVarianceReport);