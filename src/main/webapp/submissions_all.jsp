<%@ page import = "com.revature.Classes.Expense"%>
<%@ page import = "com.revature.Classes.Employee"%>
<%@ page import = "java.util.*" %>
<%@ page session = "true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complete Submissions History</title>
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
    #content{
        /*padding-top: 100px;*/
        flex: 1 0 auto;
    }
    .wrapper{
        width: 100%;
        padding: 20px;
        margin: auto;
    }
    table{
            border-collapse: collapse;
            width: 100%;
            font-family: 'Patrick Hand', cursive;;
        }
    thead{
        background-color: #ffbf00;
        color: rgb(218, 17, 17);
    }
    th, td{
    
        color: #000;
        padding: 20px;
        font-size: 22px;
        text-align: center;
        border:solid 1px black;
    }
    tr{
        /*border: 1px solid #000;*/
        
    }
    td{
        text-align: left;
        vertical-align: text-top;
        font-size: 16;
    }      

    th{
        color:rgb(218, 17, 17);
    }

    tr:nth-child(even){
        background-color: #ffd500;
    }
    .nav-link{
        color: black;
        font-size: 18pt;
        margin-left: 20px;
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
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="btn btn-outline-warning my-2 my-sm-0" style="color:rgb(218, 17, 17); border-color: rgb(218, 17, 17); font-size: 21pt;" type="button" onclick="logOut()" value="Logout"/>
            </form>
            <img src="./images/duck-front.png" width="61px" style="margin-left:5px; margin-right: 30px"/>
        </div>
    </nav>

    <!-- MAIN BODY -->
    <div id="content">
        <header style="font-size:29pt; text-align: center; margin-top: 15px; color:rgb(218, 17, 17);">Reimbursement Claims History (Complete) </header>
        <div class="wrapper">
                <form id="submission">
                    <table>
                        <thead>
                            <tr>
                                <th style="width: 15%;">Date Submitted</th>
                                <th style="width: 8%;">Employee ID</th>
                                <th style="width: 16%;">Date Processed</th>
                                <th style="width: 8%;">Manager ID</th>
                                <th style="width: 10%;">Amount</th>
                                <th style="width: 16%;">Memo</th>
                                <th style="width: 10%;">Approved/Denied</th>
                                <th style="width: 27%;">Reason</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            try{
                                ArrayList<Expense> expenses = (ArrayList<Expense>)request.getAttribute("allclaims");
                                for(Expense expense: expenses){
                            %>
                                <tr>
                                    <td><%= expense.getDateInitiated() %></td>
                                    <td><%= expense.getInitiatedBy().getId() %></td>
                                    <td><%= expense.getDateProcessed() %></td>
                                    <td><%= expense.getProcessedBy().getId() %></td>
                                    <td><%= expense.getAmount() %></td>
                                    <td><%= expense.getMemo() %></td>
                                    <td><%= expense.isApproved() %></td>
                                    <td><%= expense.getProcessorMemo() %></td>
                                </tr>
                            <%
                                }
                            }catch(Exception e){
                                out.println(e.getMessage());
                            }
                            %>
                        </tbody>
                    </table>
        </div>
    </div>

    <!-- FOOTER -->
    <div class="card text-center" style="flex-shrink: 0; width: 100%">
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
       function logOut(){
           document.location.href="LogoutServlet";
       }
    </script>
</body>
</html>