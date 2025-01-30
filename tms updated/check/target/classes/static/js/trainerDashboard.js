$(document).ready(function(){
	$('#studentlist').click(function(){
		window.location.href = '/studentlist';
	})
})


function updateElement(element) {
    const studentId = element.getAttribute('data-student-id');
    const status = element.getAttribute('data-status');
    
    console.log(`Function called with studentId: ${studentId}, status: ${status}`);
    
    if (!studentId || !status) {
        console.error('Invalid student ID or status');
        alert('Invalid student ID or status');
        return;
    }

    fetch(`/updateStatus?id=${studentId}&status=${status}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
    .then(response => response.text())
    .then(message => {
        console.log(`Response: ${message}`);
        if (message === "Status updated successfully") {
            alert('Status updated successfully!');
            location.reload();
        } else {
            alert(`Failed to update the status: ${message}`);
        }
    })
    .catch(error => console.error('Error:', error));
}