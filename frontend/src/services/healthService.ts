export async function getHealth(): Promise<string> {
  const response = await fetch('/api/health')

  if (!response.ok) {
    throw new Error('Backend not available')
  }

  return response.text()
}
