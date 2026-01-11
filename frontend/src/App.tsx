import { useEffect, useState } from 'react'
import { getHealth } from './services/healthService'

function App() {
  const [status, setStatus] = useState<'OK' | 'ERROR' | 'LOADING'>('LOADING')

  useEffect(() => {
    getHealth()
      .then(() => setStatus('OK'))
      .catch(() => setStatus('ERROR'))
  }, [])

  return (
    <div className="min-h-screen flex items-center justify-center bg-slate-900">
      <div className="text-center">
        <h1 className="text-4xl font-bold text-white mb-4">
          Backend Health
        </h1>

        {status === 'LOADING' && (
          <p className="text-yellow-400">Checking...</p>
        )}

        {status === 'OK' && (
          <p className="text-green-400 font-semibold">✅ Backend OK</p>
        )}

        {status === 'ERROR' && (
          <p className="text-red-400 font-semibold">❌ Backend DOWN</p>
        )}
      </div>
    </div>
  )
}

export default App
