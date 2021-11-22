<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submission Form</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<style>
    @import url('https://fonts.googleapis.com/css2?family=Annie+Use+Your+Telescope&family=Crafty+Girls&family=Dancing+Script&family=Lato:wght@100&family=Patrick+Hand&family=Quicksand:wght@300&family=Roboto:wght@100&display=swap');
    html{
        height: 100%;
    }
    body{
        background-color: #ffea00;
        height: 100%;
        display: flex;
        flex-direction: column;
    }
    .row{
        padding-top: 100px;
        flex: 1 0 auto;
    }
    #submission{
        width: 75%;
        font-size: 18pt;
        display: block;
        margin: auto;
        color:rgb(218, 17, 17); 
        background-color: #ffd500;
        border-radius: 20px;
        padding: 50px;
    }
    td{
        margin-left: 20px;
        margin-right: 20px;
        padding-left: 20px;
        padding-right: 20px;
        vertical-align: top;
    }
    label{
        margin-bottom:0px
    }
    .wrapper{
        display: block;
        margin:auto;
        margin-top: 50px;
    }
    .form-control{
        margin-bottom: 5px;
        background-color: rgb(223, 219, 219);
    }
    table{
        margin-left: auto;
        margin-right: auto;
    }
    .nav-link{
        color: black;
        font-size: 18pt;
        margin-left: 20px;
    }
    #formbody{
        margin-left:430px;
    }
</style>

<body style="font-family: 'Patrick Hand', cursive;">

    <!-- NAV BAR -->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffd500;">
        <a class="navbar-brand" href="index.html" style="color:rgb(218, 17, 17); font-weight: bold; font-size: 32pt; padding-left:15px">R<sup>2</sup>D<sup>2</sup> Inc.</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

            <%
                String role=(String)session.getAttribute("role");
                if(role == "manager"){
            %>
                <li class="nav-item active">
                    <a class="nav-link" href="submission_form.jsp">Submit Reimbursements <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsHistoryServlet">Past Submissions <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsPendingServlet">Pending Submissions <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsPendingAll">Submissions for Approval <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsAllServlet">All Past Submissions <span class="sr-only">(current)</span></a>
                </li>
            <%
            }else{
            %>
                <li class="nav-item active">
                    <a class="nav-link" href="submission_form.jsp">Submit Reimbursements <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsHistoryServlet">Past Submissions <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="SubmissionsPendingServlet">Pending Submissions <span class="sr-only">(current)</span></a>
                </li>
            <%}%>

            </ul>

            <form class="form-inline my-2 my-lg-0">
                <input class="btn btn-outline-warning my-2 my-sm-0" style="color:rgb(218, 17, 17); border-color: rgb(218, 17, 17); font-size: 21pt;" type="button" onclick="logOut()" value="Logout"/>
            </form>
            <img src="./images/duck-front.png" width="61px" style="margin-left:5px; margin-right: 30px"/>
        </div>
    </nav>

    <!-- MAIN BODY -->
    <div class="row" height="100%">
        <div class="col-lg-12">
            <div class="wrapper">
                <form action="NewSubmissionServlet" method="post" id="submission">
                    <p style="font-size:29pt; text-align: center;">Reimbursement Claim</p>

                    <table id="formbody">
                        <tr>
                            <td>
                                <label for="name">Name</label>
                                <p id="name"><%= session.getAttribute("name") %></p>
                            </td>
                            <td>
                                <label for="date">Date</label>
                                <p id="date"></p>
                            </td>
                        </tr>


                        <tr>
                            <td>
                                <label for="amount">Amount ($)</label>
                                <input type="text" class="form-control" id="amount" name="amount" aria-describedby="emailHelp" style="width: 100px;">
                            </td>
                            <td>
                                <label for="memo">Memo</label>
                                <input type="text" class="form-control" id="memo" name="memo" aria-describedby="emailHelp" style="width: 400px;">
                                <small id="passwordHelp" class="form-text text-muted" style="margin-bottom: 15px;">Memos limited to 255 characters</small>
                            <td>
                        </tr>
                    </table>

                    <input type="button" class="btn btn-primary" value="Submit" onclick="submitForm()" style="width: 400px; background-color: rgb(218, 17, 17); font-weight: bold; display: block; margin: auto; border-width: 0px;" />
                  </form>
            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <div class="card text-center" style="flex-shrink: 0; width: 100%;">
        <div class="card-body" style="background-color: #ffd500; color: rgb(218, 17, 17); font-weight: bold;">
          <h5 class="card-title">Reactive Rubber Duckie Distributors Incorporated (R<sup>2</sup>D<sup>2</sup> Inc.) is a wholly owned subdivision of Migrating Mallards PLC</h5>
          <p class="card-text">R<sup>2</sup>D<sup>2</sup> Inc. 33 Waterside Drive, Duckworth MA 45678   Tel: (555) 123 4567   Email: ducksinarow@r2r2.com</p>
        </div>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <script>
        var dt = new Date();
        document.getElementById("date").innerHTML = dt.toLocaleDateString();
        function submitForm(){
            document.getElementById("submission").submit();
        }
       function logOut(){
           document.location.href="LogoutServlet";
       }
    </script>

</body>
</html>