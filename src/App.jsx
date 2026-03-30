import './App.css'
import{BrowserRouter,Routes,Route} from 'react-router-dom'
import StudentLogin from './pages/student/StudentLogin'
import StudentDashboard from './pages/student/StudentDashboard'
import StudentRegister from './pages/student/StudentRegister'

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' Component={StudentLogin}/>
          <Route path='/student/dashboard' Component={StudentDashboard}/>
          <Route path='/student/register' Component={StudentRegister}/>
          <Route path='/*' Component={StudentLogin}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
