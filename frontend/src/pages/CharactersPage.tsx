// Aca vamos a manejar la logica y los estados

import { useEffect, useState } from 'react'
import { getCharacters } from '../services/characterService'
import type { Character } from '../types/Character'
import CharacterCard from '../components/CharacterCard'

export default function CharactersPage() {
  const [characters, setCharacters] = useState<Character[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    getCharacters()
      .then(setCharacters)
      .catch(() => setError('No se pudieron cargar los personajes'))
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <p>Cargando personajes...</p>
  if (error) return <p>{error}</p>

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Personajes</h1>

      <div className="flex flex-wrap gap-4">
        {characters.map(character => (
          <CharacterCard
            key={character.id}
            character={character}
          />
        ))}
      </div>
    </div>
  )
}
