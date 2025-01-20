<!DOCTYPE html>
<html>
<head>
    <title>Add Trainer</title>
  	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#addUserButton').click(function() {
                window.location.href = '/addUser';
            });
        });
    </script>
</head>
<body>
    <h1>Trainer Management</h1>

    <!-- Add Trainer Button -->
    <button type="button" id="addUserButton">Add User</button>

</body>
</html>



