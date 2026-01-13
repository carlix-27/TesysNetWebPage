import type { Character } from '../types/Character'


export async function getCharacters(): Promise<Character[]> {
  const response = await fetch('http://localhost:8080/character')

  if (!response.ok) {
    throw new Error('Error fetching characters')
  }

  return response.json()
}
