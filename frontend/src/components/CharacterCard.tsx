import type { Character } from '../types/Character'


interface Props {
  character: Character
}

export default function CharacterCard({ character }: Props) {
  return (
    <div className="border rounded-lg shadow p-4 w-64">
      <img
        src={character.image}
        alt={character.name}
        className="rounded mb-2"
      />

      <h2 className="text-lg font-bold">{character.name}</h2>

      <p className="text-sm text-gray-600">
        {character.species} – {character.status}
      </p>
    </div>
  )
}
