import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import StudentLogin from './pages/student/StudentLogin'
import StudentDashboard from './pages/student/StudentDashboard'
import StudentRegister from './pages/student/StudentRegister'
import { useState } from 'react'
import AdminLogin from './pages/admin/AdminLogin'


function App() {
  const [student, setStudent] = useState({
    name: "Nicky Singhal",
    email: "dw@dw"
  })

  //   const student1 = {
  //     name: "Nicky Singhal",
  //     email: "dw@dw"
  //   }

  //  setStudent(student1)

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' Component={StudentLogin} />
          <Route path='/student/dashboard' element={<StudentDashboard student={student} />} />
          <Route path='/student/register' Component={StudentRegister} />
          <Route path='/admin/login' Component={AdminLogin} />
          <Route path='/admin/dashboard' Component={AdminDashboard} />
          <Route path='/*' Component={StudentLogin} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
