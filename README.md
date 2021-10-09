# Student_Project
@CRUD application for student.

Apis list.
1.  http://localhost:8080/v1/student/add-student ->POST
      RequestBody:
     {
      "studentid":103,
      "studentname":"Ranjan Kumar",
      "dob":"15/05/1996",
      "doj":"22/07/2021"
     }

2. http://localhost:8080/v1/student/delete-student/103 ->DELETE

3. http://localhost:8080/v1/student/getall-student  -> GET

4.http://localhost:8080/v1/student/get-student-by-id/101  ->GET

5. http://localhost:8080/v1/student/update-studentdata/101  ->PUT
     RequestBody:
              {
             "studentname":"Gita Kumari",
            "dob":"15/05/1996",
           "doj":"22/07/2021"
           }
   